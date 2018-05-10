#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  bts.py
#  
#  Copyright 2018 genetu <genetu@genetu-Lenovo-ideapad-100S-11IBY>
#  
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#  
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#  
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#  
#  

import numpy as np

n=22

board = np.zeros((n,n),dtype='int32') # board
count =0 # number of solutions
result=[]

def ChkSafe(board,row, col):
	for i in range (row):
		if(board[i,col]== 1):
			return False
	for i,j in zip(range(row,-1,-1), range(col,-1,-1)):
		if(board[i,j] == 1):
			return False
	for i,j in zip(range(row,-1,-1), range(col,n)):
		if(board[i,j]==1):
			return False
	return True

def BTS(board, row):
    global count
    global result
    if(row >= n or count >=8):
        return
    for zcol in range(0,n):	
        if(ChkSafe(board, row,zcol)):
            board[row,zcol] =1
            result.append([row,zcol])
            if(row+1 == n):
                printresult()
                board[row,zcol] =0
                result.remove([row,zcol])
                count +=1
                return
            else:
                BTS(board, row+1)
                board[row,zcol] =0
                result.remove([row,zcol])
                
def printresult():
    print(board)
    print(result)
			
def print_result(result):
  global board
  board = np.zeros((n,n),dtype='int32')
  BTS(board,0)


print_result(result)
