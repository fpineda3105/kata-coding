def riddle(arr):
    
    def generate_max_window_size(size):
        i = 0
        max_window_size = 0
        while i < len(arr) - size + 1:
            max_window_size = max(min(arr[i:i+size]), max_window_size) 
            i+=1
        return max_window_size
    
    size = len(arr)        
    result = ''
    for i in range(1,size+1):
        result +=str(generate_max_window_size(i)) + ' '
    
    return result.strip()

print(riddle([7,8,5,9,3,4,1]))