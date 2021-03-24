#include <stdio.h>
#include <stdlib.h>

#define MAX_PROC 5

int main (int argc, char *argv[]) {
    int i;
    pid_t val_return;
    int final_state;
    for (i = 0; i < MAX_PROC; i++) {
        val_return = fork();
        if (val_return == 0) {
            printf("Fill %ld creat en la iteració = %d\n", (long)getpid(), i);
        } else {
            printf("Pare %ld, Iteració %d\n", (long)getpid(), i);
            printf("He creat un fill %ld\n", (long) val_return);
            break;
        }
    }
    sleep(10);
    while(wait(&final_state) > 0) {
        printf("Pare %ld iteració %d\n", (long)getpid(), i);
        printf("El meu fill ha dit %d\n", WEXITSTATUS(final_state));
        printf("El meu fill ha dit %d\n", final_state / 256);
    }
    exit(i);
}