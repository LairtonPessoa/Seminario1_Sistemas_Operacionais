from multiprocessing import Pool  # Importa a classe Pool do módulo multiprocessing

def quadrado(x):
    return x * x  # Função que retorna o quadrado de um número

# Cria um Pool com 4 processos
if __name__ == '__main__':  # ← Adicione esta linha!

    with Pool(4) as p:  
    # Usa o método map para aplicar a função 'quadrado' a cada elemento da lista [1, 2, 3, 4]
    # Cada número pode ser processado por um processo diferente, em paralelo
        print(p.map(quadrado, [1, 2, 3, 4]))  # Saída esperada: [1, 4, 9, 16]