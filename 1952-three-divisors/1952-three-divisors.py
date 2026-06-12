class Solution:
    def isThree(self, n: int) -> bool:
        counter = 0
        sqr = int(math.sqrt(n))
        for i in range(1,sqr+1):
            if(n%i==0):
                counter += 1
                if(n//i!=i):
                    counter +=1
        if(counter == 3):
            return True
        else :
            return False
        