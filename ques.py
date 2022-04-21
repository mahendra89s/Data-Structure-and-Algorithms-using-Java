list = [12,34,56,78,34]

while(len(list)>2):
    for i in range(0,len(list)-2):
        list[i] = (list[i] + list[i+1])%10
print(list)