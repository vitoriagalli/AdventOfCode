
#!/usr/bin/env python3
import re

def data_parser(filepath):
	tmp = open(filepath).read()
	tmp = [line for line in tmp.split('\n') if line]
	data = []
	for line in tmp:
		operation, argument = line.split(' ')
		data.append([operation, int(argument), False])
	return data

def accumulator_value(data):
	i = 0
	acc = 0
	while not data[i][2] and i < len(data):
		data[i][2] = True
		if data[i][0] == 'acc':
			acc += data[i][1]
		if i == len(data) - 1:
			break
		if data[i][0] == 'jmp':
			i += data[i][1]
		else:
			i += 1
	return acc, data[len(data)-1][2]

def reset_data(data):
	for instruction in data:
		instruction[2] = False

def change_operation(operation, data, i):
	if operation == 'nop':
		data[i][0] = 'jmp'
	elif operation == 'jmp':
		data[i][0] = 'nop'
	acc, last_command = accumulator_value(data)
	data[i][0] = operation
	if last_command:
		return acc
	return False

def part_1(data):
	"""
	the value in the accumulator
	"""
	acc, last_command = accumulator_value(data)
	return print("part 1:", acc)

def part_2(data):
	"""
	fix that one corrupted instruction
	the value of the accumulator after the program terminates
	"""
	for i, line in enumerate(data):
		reset_data(data)
		acc = change_operation(data[i][0], data, i)
		if acc:
			break
		else:
			i += 1
	return print("part 2:", acc)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
