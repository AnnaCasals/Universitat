#include <stdio.h> 

#define TAM_FILA 100
#define NUM_FILAS 10
struct FILA {
    float datos[TAM_FILA];
    float suma;
};
   

void suma_fila(struct FILA *pf) {
// B) Implementar suma_fila
    int i;
    for(i=0; i < TAM_FILA; i++){
      pf -> suma += pf -> datos[i];
    }
}

// Inicia las filas con el valor i*j
void inicia_filas(struct FILA *pf) {
    int i, j;
    for (i = 0; i < NUM_FILAS; i++) {
        for (j = 0; j < TAM_FILA; j++) {
	    pf -> datos[j] = (float)i*j;
	    //filas[i].datos[j] = (float)i*j;
        }
    }
}
main() { 
    struct FILA filas[NUM_FILAS];
    int i;
    float suma_total;
    
    inicia_filas(&filas[i]);
    
    suma_total = 0;
    for (i = 0; i < NUM_FILAS; i++) {
        suma_fila(&filas[i]);
        printf("La suma de la fila %u es %f\n", i, filas[i].suma);
	suma_total += filas[i].suma;
    }
    printf("La suma final es %f\n", suma_total); 
}

