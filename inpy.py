class Solution:
    def checkValid(self, matrix: List[List[int]]) -> bool: 
        result = True                                       #considera a resposta como verdadeira até que se prove falsa
        size = len(matrix[0])                               #mede o tamanho da matriz
        
        for i in range(size):                               #primeiro for, para encotrar as linhas e colunas da matriz
            row = Solution.grablist(matrix, i, True)        #puxa cada linha da matriz
            column = Solution.grablist(matrix, i, False)    #puxa cada coluna da matriz

            for k in range(size):                           #segundo for, para iterar dentro de cada linha e coluna se falta algum número
                if k+1 not in row or k+1 not in column:     #se falta um número na linha ou coluna...
                    result = False                          #... então resultado só pode ser falso...
                    break                                   #... e pode quebrar o segundo for
            
            if result == False: break                       #... e também quebra o 1o for

        return result
        
    # função abaixo para auxiliar a solução, recebe uma matriz, uma posição 'index' da matriz e se deseja-se linha ou coluna.
    # Retorna uma lista da enésima linha ou coluna da matriz.
    
    def grablist(matrixB: List[List[int]], index: int, isLine: bool) -> List[int]:
        if isLine == True:
            return matrixB[index]                           #para linha pega a enésima linha da matriz
        else:
            col = []
            for k in range(len(matrixB[0])):                #para coluna pega o enésimo item de cada linha.
                col.append(matrixB[k][index])               #e acrescenta ao fim de uma lista 'col'.
            return col
