#include <stdio.h>
#include <stdlib.h>

int main (int argc, char *argv[]) {
    int i;
    for (i = 0; i < 5; i++) {
        if (fork() == 0) {
            printf("Fill creat en iteració = %d\n", i);
            sleep(20);
            exit(i);
        }
    }
    sleep(10);
    exit(0);
}