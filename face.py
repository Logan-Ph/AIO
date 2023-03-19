def mergeOverlappingIntervals(intervals):
    intervals.sort(key = lambda i:i[0])
    print(intervals)
    output = [intervals[0]]

    for start,end in intervals[1:]:
        lastend = output[-1][1]
        if start > lastend:
            output.append([start,end])
        else:
            output[-1][1] = max(end,lastend)
    return output
            
intervals =[
  [1, 2],
  [3, 5],
  [4, 7],
  [6, 8],
  [9, 10]
]

output = mergeOverlappingIntervals(intervals)
print(output)