# -*- coding: utf-8 -*-
"""
Created on Mon Feb 20 20:07:01 2017

@author: Conder
"""
#Problem 1

class Constraint:
    def __init__(self, varnames, coes, total):
        self.varnames = varnames
        self.coes= [float(c) for c in coes]
        self.total = float(total)
        self.varvals = [None] * len(coes)
        
    def __str__(self):
        return self.__repr__()
    
    def __repr__(self):
        # display the status of the constraint
        # show which vars have values
        x = ' + '.join(['{}*{}(={})'.format(coe, var, val) 
                        for coe,var,val in zip(self.coes, self.varnames, self.varvals)])
        return 'Constraint({}={})'.format(self.total, x)
    