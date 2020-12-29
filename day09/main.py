
#!/usr/bin/env python3
import re

def data_parser(filepath):
	string = open(filepath).read()
	return [int(line) for line in string.split('\n') if line]

def find_sum(data):
	for i, x in enumerate(data[:-1]):
		for j, y in enumerate(data[i:-1]):
			if (x + y) == data[len(data)-1]:
				return True
	return False

def invalid_number(preamble, data):
	i = preamble
	while i < len(data):
		if not find_sum(data[i-preamble:i + 1]):
			return data[i]
		i += 1
	return False

def contiguous_set(numb, data):
	for i, n in enumerate(data):
		sum = 0
		j = i
		while sum < numb:
			sum += data[j]
			if sum == numb:
				range = data[i:j]
				return(min(range), max(range))
			j +=1
	return False

def part_1(data):
	"""
	the first number that does not have the property
	"""
	return print("part 1:", invalid_number(25, data))

def part_2(data):
	"""
	contiguous set of at least two numbers in your list which sum to the invalid number from step 1.
	"""
	min, max = contiguous_set(invalid_number(25, data), data)
	return print("part 2:", min + max)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
