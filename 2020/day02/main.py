
#!/usr/bin/env python3
import re

def data_parser(filepath):
	return open(filepath).read().split('\n')

def part_1(data):
	"""
	number of valid passwords according to their policies
	range of times a given letter must appear for the password
	"""
	valid_password = 0
	for line in data:
		try:
			params = re.split(' |-|: ', line)
			if int(params[0]) <= params[3].count(params[2]) <= int(params[1]):
				valid_password += 1
		except:
			pass
	return print("part 1:", valid_password)

def part_2(data):
	"""
	number of valid passwords according to their policies.
	exactly one of these positions must contain the given letter
	"""
	valid_password = 0
	for line in data:
		try:
			params = re.split(' |-|: ', line)
			if (params[3][int(params[0]) - 1] == params[2]) ^ (params[3][int(params[1]) - 1] == params[2]):
				valid_password += 1
		except:
			pass
	return print("part 2:", valid_password)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
