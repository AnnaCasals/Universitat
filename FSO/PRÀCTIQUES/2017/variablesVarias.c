#include <stdio.h>
int a = 0; /* variable global */
// Esta funció incrementa el valor de la variable global a en 1
void inc_a(void) {
  a++;
  }
  //Esta funció torna el valor anterior i guarda el nou valor v
  int valor_anterior(int v) {
    int temp;
    static int s;// declarar ací la variable s estàtica.
    temp = s;
    s = v;
    return temp;
    }
main() {
  int b = 2; /* variable local */
  inc_a();
  valor_anterior(b);
  printf("a= %d, b=%d\n", a, b);
  a++;
  b++;
  inc_a();
  b = valor_anterior(b);
  printf("a=%d, b=%d \n", a, b);
  }