
# coding: utf-8

# # Assignment 1, 8-Puzzle Programming

# Your homework must be implemented in this Notebook file. 
# You can add as many cells as you want. However, you are not allowed to touch the code below the line "=============".
# You need to implement the three (four for grads) searching functions and the print result functions.
# For the searching functions, feel free to customize the return data types and parameter lists as long as the function name is as required.
# 

# In[ ]:


import itertools
import copy

goal_list = list(range(0,9))
t = [2, 0, 7, 5, 1, 8, 6, 3, 4]
goal = [goal_list[i:i+3] for i in range(0, len(goal_list), 3)]
puzzle = [t[i:i+3] for i in range(0, len(t), 3)]

def board(puz):
    moves=[]
    zrow, zcol = next((r,c)
        for r, i in enumerate(puz)
            for c, n in enumerate(i) if n==0)

    def swap(row, col):
        s = copy.deepcopy(puz)
        s[zrow][zcol], s[row][col] = s[row][col], s[zrow][zcol]

        return s

    if zrow >0:
        moves.append(swap(zrow-1, zcol))
    if zrow < 2:
        moves.append(swap(zrow+1, zcol))
    if zcol> 0:
        moves.append(swap(zrow, zcol-1))
    if zcol < 2:
        moves.append(swap(zrow, zcol+1))

    return moves 


# In[ ]:


#implementation of function "Iterative_deepening_DFS"

def IDDFS(puzzle, goal):
    # fin =open("Input8PuzzleCasesUpdates.txt", "r")

    def DFS(path, depth):
        if depth == 0:
            return
        if path[-1] == goal:
            return path
        for move in board(path[-1]):
            if move not in path:
                next_path = DFS(path+[move], depth-1)
                if next_path:
                    return next_path

    for depth in itertools.count():
            path  = DFS([puzzle], depth)
            if path:
                return path


# In[ ]:


#implementation of function "aStarMisplacedTiles"

def Misplaced(puzz):
    miss =0
    near =0
    s = copy.deepcopy(puz)
    for r in range(3)
        for c in range(3)
            if s[r][c]!= nxt
                miss +=1
            near +=1
            
    return miss


# In[ ]:


#implementation of function "aStarManhattanDistance"

def Manh_Distance(puzz):
    distance =0
    s = copy.deepcopy(puz)
    for r in range(3)
        for c in range(3)
            if s[r][c]== 0:
                continue
            distance += (abs(r -(s[r][c]/4))+abs(c- (s[r][c]%4)))
    return distance


# In[ ]:


def A_Star(puzzle, goal, h):
    
    if(h== 1)
        a = Misplaced(puzzle)
    elif(h==2)
        a = Manh_Distance(puzzle)
    
    frin = [[a, puzzle]]
    exp =[]
    nodes =0
    while frin:
        i=0
        for j in range(1, len(frin)):
            if( len(frin[i]) >len(frin[j])):
                i=j
        path =frin[i]
        frin = frin[:i]+ frin[i+1:]
        
        if(path[-1] == goal):
            return
        if(path[-1] in exp):
            continue
        for move in board(path[-1])
            if move in exp:
                continue
            if(h== 1)
                a = Misplaced(k)
                e = Misplaced(path[-1])
            elif(h==2)
                a = Manh_Distance(k)
                e = Manh_Distance(path[-1])
                
            next_path = [path[0] + a-e]+path[1:]+[k]
            frin.append(next_path)
            exp.append(path[-1])
        exp +=1
    return path


# In[4]:


#implementation of function "breadthFirstSearch" (for graduate students)


# In[ ]:


#implementation of function "print_result(result)"

def print_result:
    #1
    start = dt.datetime.now()
    result = IDDFS(puzzle, goal)
    end = dt.datetime.now()
    time = end- start

    print("The length of solution 1 is :" , len(result)," moves")
    print("Time needed :", time)
    
    #2
    start = dt.datetime.now()
    result = A_Star(puzzle, goal,1)
    end = dt.datetime.now()
    time = end- start

    print("The length of solution 2 is :" , len(result)," moves")
    print("Time needed :", time)
    
    #3
    start = dt.datetime.now()
    result = A_Star(puzzle, goal,2)
    end = dt.datetime.now()
    time = end- start

    print("The length of solution 3 is :" , len(result)," moves")
    print("Time needed :", time)


# You can insert as many cells as you want above
# You are not Allowed to modify the code below this line.
# ===============================

# In[2]:


#you need to implement print_result function to print out the result according to the required format
print_result(result)


# 
# The output format should be as follows. You only need to give one sample solution as an example.
# +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
# Solution of the first Scenario:
# X X X
# X X X
# X X X
# to
# X X X
# X X X
# X X X
# to
# X X X
# X X X
# X X X
# to
# X X X
# X X X
# X X X
# to
# .
# .
# .
# 0 1 2
# 3 4 5
# 6 7 8
# 
#                 Average_Steps    Average_Time   Average_Iterations   
# UCS
# A*(Misplaced)
# A*(Manhattan)
# BFS
# 
# 
