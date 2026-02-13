T = int(input())

for test_case in range(1, T + 1):
    # N: 초기 원소 개수, M: 명령 횟수, L: 출력할 인덱스 번호
    N, M, L = map(int, input().split())
    
    # 초기 리스트 구성
    data_list = list(map(int, input().split()))
    
    for _ in range(M):
        command = input().split()
        cmd_type = command[0]
        
        if cmd_type == 'I':  # Insert
            idx, val = int(command[1]), int(command[2])
            data_list.insert(idx, val)
            
        elif cmd_type == 'D':  # Delete
            idx = int(command[1])
            if idx < len(data_list):
                data_list.pop(idx)
                
        elif cmd_type == 'C':  # Change
            idx, val = int(command[1]), int(command[2])
            if idx < len(data_list):
                data_list[idx] = val

    if L < len(data_list):
        print(f"#{test_case} {data_list[L]}")
    else:
        print(f"#{test_case} -1")