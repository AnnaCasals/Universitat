#include <stdio.h>

int main(int argc, char *argv[]) {
  printf("Número de arguments = %i\n", argc);
  int i;
  for(i = 0; i < argc; i++) {
    printf("Argument %i és %s\n", i, argv[i]);
    }
  return 0;
}