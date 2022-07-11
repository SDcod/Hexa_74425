import os


class ceo:
        
       
    def create(self):
        
        ceo=open("ceo.txt","x")
        c=open("ceo.txt","a")
        self.id=input('Enter the ID: ')
        self.name=input('Enter the Name: ')
        self.age=input('Enter the Age: ')
        self.salary=input('Enter the Salary: ')
        self.desig='ceo'
        c.write("Id : "+self.id+"\n")
        c.write("Name : "+self.name+"\n")
        c.write("Age : "+self.age+"\n")
        c.write("Salary : "+self.salary+"\n")
        c.write("Designation : "+self.desig+"\n")
        c.close()

    def display(self):            
                print('***********ceo************')
                cl=open("ceo.txt",'r')
                print(cl.read())
                print('***********************')                
                
        

class marketer:        
       
    def create(self):
        
        
        
        marketer=open("marketer.txt","x")
        m=open("marketer.txt","a")
        self.id=input('Enter the ID: ')
        self.name=input('Enter the Name: ')
        self.age=input('Enter the Age: ')
        self.salary=input('Enter the Salary: ')
        self.desig='marketer'
        m.write("Id : "+self.id+"\n")
        m.write("Name : "+self.name+"\n")
        m.write("Age : "+self.age+"\n")
        m.write("Salary : "+self.salary+"\n")
        m.write("Designation : "+self.desig+"\n")
        m.close()
            
    def display(self):
            
                print('*********marketer**************')
                ma=open("marketer.txt",'r')
                print(ma.read())
                print('***********************')
            
       
class trainer:
        
    def create(self):         
                
        trainer=open("trainer.txt","x")
        t=open("trainer.txt","a")
        self.id=input('Enter the ID: ')
        self.name=input('Enter the Name: ')
        self.age=input('Enter the Age: ')
        self.salary=input('Enter the Salary: ')
        self.desig='trainer'
        t.write("Id : "+self.id+"\n")
        t.write("Name : "+self.name+"\n")
        t.write("Age : "+self.age+"\n")
        t.write("Salary : "+self.salary+"\n")
        t.write("Designation : "+self.desig+"\n")
        t.close()
        
    def display(self):
           
                print('***********trainer************')
                te=open("trainer.txt",'r')
                print(te.read())
                print('***********************')
                
       

class designer:
      
    def create(self):
            
        
        
        designer=open("designer.txt","x")
        d=open("designer.txt","a")
        self.id=input('Enter the ID: ')
        self.name=input('Enter the Name: ')
        self.age=input('Enter the Age: ')
        self.salary=input('Enter the Salary: ')
        self.desig='designer'
        d.write("Id : "+self.id+"\n")
        d.write("Name : "+self.name+"\n")
        d.write("Age : "+self.age+"\n")
        d.write("Salary : "+self.salary+"\n")
        d.write("Designation : "+self.desig+"\n")
        d.close()
    def display(self):
            
                print('**********designer*************')
                de=open("designer.txt",'r')
                print(de.read())
                print('***********************')

T=trainer()
D=designer()
M=marketer()
C=ceo()


       
while True:
    print('========================== Staf Manager ==============================')
    print('Choose the options:\n 1.Create Staff \n 2.Display Staff \n 3. Exit App')
          
    opt=int(input('Enter the option: '))
    if opt==1:
        print('1. ceo')
        print('2. marketer')
        print('3. trainer')
        print('4. designer')
        n=int(input('Enter the option: '))
        if n==1:
           if os.path.exists("ceo.txt"):
               print('ceo data already exists');
               continue
           else:
                C.create()
                continue
        elif n==2:
            if os.path.exists("marketer.txt"):
               print('marketer data already exists');
               continue
            else:
                M.create()
                continue
        elif n==3:
            if os.path.exists("trainer.txt"):
               print('trainer data already exists');
               continue
            else:
                T.create()
                continue
        elif n==4:
            if os.path.exists("designer.txt"):
               print('designer data already exists');
               continue
            else:
                D.create()
                continue
        else:
            print('Wrong option')
        continue

    elif opt==2:
        
        print('1. ceo')
        print('2. marketer')
        print('3. trainer')
        print('4. designer')
        n=int(input('Enter the option:'))
        if n==1:
            if os.path.exists("ceo.txt"):
                
                C.display()
                continue
            else:
                C.create()
                C.display()
                continue
        
        elif n==2:
           if os.path.exists("marketer.txt"):
               M.display()
               continue
           else:
                M.create()
                M.display()
                continue
        elif n==3:
            if os.path.exists("trainer.txt"):
               T.display()
               continue
            else:
                T.create()
                T.display()
                continue
        elif n==4:
            if os.path.exists("designer.txt"):
               D.display()
               continue
            else:
                D.create
                D.display()
                continue
        else:
            print('Please enter valid choice!')
        continue
        

    
            
       
    elif opt==3:
        print('ThankYou...........')
        break

    else:
        print('Enter Valid choice')
