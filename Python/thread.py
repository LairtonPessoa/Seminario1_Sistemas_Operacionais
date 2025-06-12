import threading  # Importa o módulo 'threading' para trabalhar com múltiplas threads

contador = 0  # Variável global compartilhada entre todas as threads
lock = threading.Lock()  # Cria um objeto Lock para evitar condições de corrida

def incrementar():
    global contador  # Indica que estamos usando a variável global 'contador'
    for _ in range(100000):  # Repete 100.000 vezes
        with lock:  # Garante que apenas uma thread execute essa parte por vez
            contador += 1  # Incrementa o valor do contador de forma segura

# Cria uma lista com 5 threads, todas executando a função 'incrementar'
threads = [threading.Thread(target=incrementar) for _ in range(5)]

# Inicia todas as threads
for t in threads:
    t.start()

# Espera todas as threads terminarem antes de continuar
for t in threads:
    t.join()

# Imprime o valor final do contador (esperado: 5 * 100000 = 500000)
print("Contador final:", contador)