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
def cbt(objList):
    d = dict()

    for j in objList:
        d.setdefault(type(j), [])
        d[type(j)].append(j)
        
    for key, value in d.items():
        print('found {}, of {}'.format(str(len([item for item in value if item])), str(key)))
    
    someInt = type(int(23))
    intValues = d.get(someInt)
    intSum = sum(intValues)
    print('sum of {} is {}'.format(someInt, intSum))
  
    someF = type(float(23))
    fValues = d.get(someF)
    fSum = sum(fValues)
    print('sum of {} is {}'.format(someF, fSum))
  
    stringL = d.get(type(str('hi')))
    stringL = sorted(stringL)
    stringL = '|'.join(stringL)
    
    print('alpha sorted concat of strings: {}'.format(stringL))
    
    return d
    
x = [23, 2**20, 3.14, "shapiro", 2**10+7, sorted, 2.34, 'science', len, 43, "butler", 'unicode']
#print(cbt(x))
#cbt(x)

#Problem 3

def partition(inputL, lenS, overlap):
    
    output = []
    seg = []
    i = 0
    counter = 0
    
    while i <= len(inputL) and overlap < lenS:
        
        if counter >= lenS:
            output.append(seg)
            counter = 0
           
            if overlap > 0:
                seg = seg[lenS - overlap:lenS]
                counter += overlap
            else:
                seg = []
                
        if i < len(inputL) and counter < lenS:
            seg.extend([inputL[i]])
        
        i += 1
        counter += 1
        
    return output
    
    
#print(partition(list(range(10)), 2, 0))
#print(partition(list(range(10)), 3, 0))
#print(partition(list(range(10)), 2, 1))
#print(partition(list(range(10)), 4, 0))
#print(partition(list(range(10)), 4, 3))

#Problem 4a
def expandlazy(x):

    if isinstance(x, range) or isinstance(x, zip) or isinstance(x, enumerate):
        output = list(x)
    else:
        output = x
    
    return output

#print(expandlazy(234), expandlazy(range(3)), expandlazy('asdf'), expandlazy(enumerate(['a','b','c'])))

#Problem 4b
def expandlazylist(x):
  
    output = []

    for j in x: 
        if isinstance(j, range) or isinstance(j, zip) or isinstance(j, enumerate):
            output.append(list(j))
        else:
            output.extend([j])
    
    return output
            
x = [1,2,3, range(4), 5, zip([1,2,3], [4,5]), 'asdf', enumerate(['a', 'b', 'c'])]
#print(expandlazylist(x))

#Problem 5
def flatten(x):
    
    output = []
    for j in x:
        if isinstance(j, list):
            output.extend(flatten(j))
        else:  
            output.extend([j])
        
    return output

print(flatten([1,[2,3,4,[5,6,[7,8],9],11]]))