#!/usr/bin/env python3

def data_parser(filepath):
	string = open(filepath).read()
	data = [0] * 30000000
	for i, line in enumerate(string.split(',')):
		if line:
			data[i] = int(line.replace('\n',''))
	return data

def check_dup_value(data, max_i):
	for n in reversed(range(0, max_i)):
		if data[max_i] == data[n]:
			return (n)
	return -1

def part_1(data):
	"""
	what will be the 2020th number spoken
	"""
	last_posit = -1
	for i in range(0, 2020):
		if last_posit >= 0:
			data[i] = i - last_posit - 1
		last_posit = check_dup_value(data, i)
	return print("part 1:", data[2019])

def part_2(data):
	"""
	what will be the 30000000th number spoken?
	"""
	last_posit = -1
	for i in range(0, 30000000):
		if last_posit >= 0:
			data[i] = i - last_posit - 1
		last_posit = check_dup_value(data, i)
	return print("part 2:", data[29999999])

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()

