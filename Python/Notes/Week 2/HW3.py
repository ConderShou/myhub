#Problem 1a

def decimals(n):
    r = 10
    while (r != 0):
        q, r = divmod(r, n)
        r *= 10
        yield q

#Problem 1b
def genlimit(g, limit):
    l = 0
    while (l < limit):
            l += 1
            yield next(g)

#Problem 2
def decimals2(n):
    r = 10
    seen = []
    repeatList = []

    while (r != 0):
        q, r = divmod(r, n)
        qrList = [q, r]
        seen.extend(qrList)
        
        for j in range(0, len(seen)-2, 2):
            if (q == seen[j] and r == seen[j+1]):
                for i in range(0, len(seen)-2, 2):
                    repeatList.extend([seen[i]])
                yield repeatList
                return
        r *= 10
        yield q
        
        
#Problem 3a
def select(input, selectors):
    newL = []
    for j, c in enumerate(input):
        if (c and selectors[j]):
            newL.extend([c])
    return newL
    
#Problem 3b
def intToNDigits(x, n):
    binStr = bin(x)
    binStr = binStr.lstrip('0b')
    digitsL = []

    if (len(binStr) < n):
        addStr = "0" * (n - len(binStr))
        binStr = addStr + binStr
  
    for s in binStr:
        digitsL.extend([int(s)])

    return digitsL        
    

#Problem 3c
def powerSet(x):
  
    binList = []
    for c in range(len(x)):
        binList.extend([0])

    setList = []

    for j in range(0, (2**len(x))):
        newSet= set()
        compareList = intToNDigits(j, len(x))
 
        for i in range(len(x)):
            binList[i] = 1
            newL = select(compareList, binList)
            if (1 in newL):
                newSet.add(x[i])
            binList[i] = 0
                
        setList.append(newSet)
    return setList
    
#problem 4
def dotn(*pos):
    dotP = 0
    num = len(pos)
    argList = []

    for i in range(num):
        argList.append([])
        for j in pos[i]:
            argList[i].extend([j])

    argTuples = list(zip(*argList))
    prod = 1
    for j, item in enumerate(argTuples):
        for i in item:
            prod = prod * i   
        dotP += prod
        prod = 1
        
    return dotP

#Problem 5a
def countBases(dna):
    genes = {}
    a = 0
    c = 0
    g = 0
    t = 0
    for char in dna:
        if char == 'A':
            a += 1
        elif char == 'C':
            c += 1
        elif char == 'G':
            g += 1
        elif char == 'T':
            t += 1
    genes['A'] = a
    genes['C'] = c
    genes['G'] = g
    genes['T'] = t

    return genes
    
    print(string)

#Problem 5b
def percentBases(dna):
    genesDict = countBases(dna)
    
    total = 0
    a = genesDict.get('A') 
    c = genesDict.get('C') 
    g = genesDict.get('G')
    t = genesDict.get('T')
    total += a + c + g + t
    genesDict['A'] = a/total
    genesDict['C'] = c/total
    genesDict['G'] = g/total
    genesDict['T'] = t/total

    return genesDict
    
#Problem 5c
def reverseComplement(dna):
    
    dnaList = list(dna)
    for i, item in enumerate(dna):
        if (item == 'A'):
           dnaList[i] = 'T'
        elif (item == 'C'):
           dnaList[i] = 'G'
        elif (item == 'G'):
            dnaList[i] = 'C'
        elif (item == 'T'):
            dnaList[i] = 'A'
       
    dnaList = dnaList[::-1]
    dna = "".join(dnaList) 
    
    return dna

dna = 'CATCGATATCTCTGAGTGCAC'
print(reverseComplement(dna))


