//Programa SumaSequencial.c
//Per a compilar teclegeu:
// gcc SumaSequencial.c -o SumaSeq -lm
#include <stdio.h>
#include <pthread.h>
#include <math.h>

#define DIMFILERA 1000000
#define NUMFILERES 20

typedef struct filera{
        int vector[DIMFILERA];
        long suma;
} filera;

filera matriu[NUMFILERES];

void *SumaFilera( void *ptr )
 {
   int k;
   filera *fi;
   fi=(filera *)  ptr;

   fi->suma=0;
   for(k=0;k<DIMFILERA;k++) {
     fi->suma += exp((k*(fi->vector[k])
                     +(k+1)*(fi->vector[k]))/(fi->vector[k]+2*k))/2;
   }
 }
 
 void *Sumar(int i) {
   int a = NUMFILERES / 4;
   int b = NUMFILERES / 4;
   for (int j = a; j < b; j++){
     SumaFilera(&matriu[j]);
   }
 }

int main()
{
  int i,j;
  long suma_total=0;
  pthread_t  fils[NUMFILERES];
  pthread_attr_t atrib;
  //s'inicialitzen a 1 tots els elements de tots els vectors
  for(i=0;i<NUMFILERES;i++) {
      for(j=0;j<DIMFILERA;j++) {
         matriu[i].vector[j]=1;
      }
  }
  //Iniciació dels atributs de fil
  //Estos atributos se pueden usar en los hilos creen
  pthread_attr_init( &atrib );
  //pthread_attr_setscope(&atrib, PTHREAD_SCOPE_SYSTEM);

 //EJERCICIO2.a
 for(i=0;i<4;i++)
  {
      pthread_create(&fils[i], &atrib, Sumar, &i);
  }
 //EJERCICIO2.b

 for(i=0;i<4;i++) {
   pthread_join(fils[i], NULL); 
   suma_total+=matriu[i].suma;
 printf(  "La suma val %ld\n",suma_total);

}
}

