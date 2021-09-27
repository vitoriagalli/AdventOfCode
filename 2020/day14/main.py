#!/usr/bin/env python3
import re

def parse_line(string):
	if string[:4] == 'mask':
		return(re.sub(r'mask = ([01X]+)', r'\1', string))
	else:
		addr, value = string.split(' = ')
		addr = addr.replace('mem[', '').replace(']', '')
		value = "{:036b}".format(int(value))
		return [int(addr), value]

def data_parser(filepath):
	string = open(filepath).read()
	data = []
	for line in string.split('\n'):
		if line:
			data.append(parse_line(line))
	return data

def apply_mask(mask, value):

	value = list(value)
	mask = list(mask)
	for i in range(0, len(mask)):
		if mask[i] is not 'X' and mask[i] is not value[i]:
			value[i] = mask[i]
	return "".join(value)

def part_1(data):
	"""
	the sum of all values left in memory after it completes
	"""
	addrs = [int(i[0]) for i in data if i[0] is not 'X']
	mem = [0] * (max(addrs) + 1)
	for value in data:
		if len(value) > 2:
			mask = value
		else:
			mem[value[0]] = int(apply_mask(mask, value[1]), 2)
	return print("part 1:", sum(mem))

def part_2(data):
	"""
	the sum of all values left in memory after it completes
	"""
	return print("part 2:", )

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()

