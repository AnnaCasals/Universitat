/**
* Programa d'exemple "Hola món" amb pthreads. 
* Per a compilar teclegeu:
*     gcc hola.c -lpthread -o hola 
*/ 
#include <stdio.h> 
#include <pthread.h> 
#include <string.h>
#include <unistd.h>
void *Imprimeix( void *ptr ) 
  { 
    char *missatge;
    missatge=(char*)ptr; 
    //EXERCICI1.b 
    usleep(2000000000);
    write(1,missatge,strlen(missatge)); 
  } 
int main() 
  { 
    pthread_attr_t atrib; 
    pthread_t fil1, fil2; 
    
    pthread_attr_init( &atrib ); 
    
    pthread_create( &fil1, &atrib, Imprimeix, "Hola \n"); 
    pthread_create( &fil2, &atrib, Imprimeix, "món \n"); 
   //EXERCICI1.a 
    usleep(1000000000);
    //pthread_exit(0);  
} 