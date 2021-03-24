#include <stdio.h>
#define TAM_CADENA 200
main() {
     //puntero a caracter per a copiar les cadenes
     char *p1, *p2;

     // A) definir les variables cadena i cadena2
     char cadena [TAM_CADENA];
     char cadena2 [TAM_CADENA];

     //B) Leer cadena de consola
      printf ("Introdueix text: ");
      scanf ("%[^\n]s", cadena);

     //C) Convertir a majúscules 
      p1 = cadena;
      p2 = cadena2;
      while (*p1 != '\0') {
	  //Copiar p1 a p2 restant 32
         if(*p1 >= 'a' || *p1 <= 'z'){
	   *p2 = *p1 - 32;
	 }
	 else {*p2 = *p1;}
	 *p1++;
	 *p2++;
      }



//acordaros de poner el cero final en cadena2
*p2 = 0;

//D) traure per consola la cadena 2
printf ("La cadena 2 es: %s\n", cadena2);
}