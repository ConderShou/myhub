tv0 = [1,2,3]
tv1 = [4,5,6,7,8,9]

#Problem 1a
def dot(tv0, tv1):
    
    if len(tv0) > len(tv1):
        vector = tv1
    else:
        vector = tv0
    
    dotP = 0
     
    for j, elem in enumerate(vector):
        dotP += tv0[j] * tv1[j]
    
    return dotP
    
#print(dot(tv0, tv1))

#Problem 1b
def shortlong(tv0, tv1):
    
    if len(tv0) > len(tv1):
        shortV = tv1
        longV = tv0
    else:
        shortV = tv0
        longV = tv1
    
    vector = []

    vector.append(shortV) 
    vector.extend([len(shortV)])
    vector.append(longV)
    vector.extend([len(longV)])
    
    return vector
    
#print(shortlong(tv0, tv1))
#print(shortlong(tv1, tv0))

#Problem 1c
def dotmv(tv0, tv1, n):
    
    vector = shortlong(tv0, tv1)
    shortV = vector[0]
    longV = vector[2]

    dotP = 0
    
    for j, elem in enumerate(shortV):
        dotP += shortV[j] * longV[j+n]

    return dotP
    
#print([dotmv(tv0, tv1, 0), dotmv(tv0, tv1, 1), dotmv(tv0, tv1, 2)])

#Problem 1d - MAKE A COPY OF THE VECTORS, DONT MODIFY THEM
import copy

def dotpad(tv0, tv1, n):
    vector = shortlong(tv0, tv1)
    
    #slicing only creates a SHALLOW copy
    copiedV = copy.deepcopy(vector) 
    
    shortV = copiedV[0]
    longV = copiedV[2]
    
    dotP = 0
    
    for j, elem in enumerate(longV):
        
        if j >= len(shortV):
            shortV.extend([n])
        
        dotP += shortV[j] * longV[j]
  
    return dotP
    
    
#print([dotpad(tv0, tv1, 0), dotpad(tv0, tv1, 1), dotpad(tv0, tv1, 2)])

#Problem 2
