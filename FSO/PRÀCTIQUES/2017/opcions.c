#include <stdio.h>

int main(int argc, char *argv[]) {
  int i;
 for(i=1; i< argc; i++) {
  printf("Arguments %i és ", i);
  switch(argv[i][1]){
    case 'c':
      printf("Compilar"); 
      break;
    case 'E':
      printf("Preprocesar");
      break;
    case 'i':
      printf("Incluir %s", &argv[i][2]);
      break;
    default:
      printf("Opció no vàlida");
    }
    printf("\n");
 }
 return 0;
}
