#include <stdio.h>
#include <pthread.h>

void* minhaThread(void* arg) {
    int id = *((int*)arg);
    printf("Olá! Eu sou a thread %d\n", id);
    return NULL;
}

int main() {
    pthread_t t1, t2;
    int id1 = 1, id2 = 2;

    // Cria duas threads
    pthread_create(&t1, NULL, minhaThread, &id1);
    pthread_create(&t2, NULL, minhaThread, &id2);

    // Espera as threads terminarem
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    printf("Todas as threads terminaram.\n");
    return 0;
}
