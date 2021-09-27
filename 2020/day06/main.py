
#!/usr/bin/env python3
import re
import json

def data_parser(filepath):
	'''
	convert file info (string) to list
	'''
	string = open(filepath).read()
	string = str([line for line in string.split('\n')])
	string = re.sub(r'\'', r'"', string)
	string = re.sub(r'[,][ ]["]["][,][ ]["]([a-z])', r'], ["\1', string)
	string = re.sub(r'[,][ ]["]["]', r'', string)
	string = '[' + string + ']'
	data = json.loads(string)
	return data

def part_1(data):
	"""
	for each group, count the number of questions to which anyone answered "yes"
	return the sum of those counts
	"""
	sum = 0
	for group in data:
		answer_group = ""
		for person in group:
			for answer in person:
				if answer not in answer_group:
					answer_group += answer
		sum += len(answer_group)
	return print("part 1:", sum)

def part_2(data):
	"""
	for each group, count the number of questions to which everyone answered "yes"
	return the sum of those counts
	"""
	sum = 0
	for group in data:
		answer_group = ""
		for person in group:
			for answer in person:
					answer_group += answer
		same_answer = ""
		for c in answer_group:
			if answer_group.count(c) == len(group) and c not in same_answer:
				same_answer += c
		sum += len(same_answer)
	return print("part 2:", sum)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
