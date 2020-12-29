
#!/usr/bin/env python3

def data_parser(filepath):
	string = open(filepath).read()
	return [(line[0], int(line[1:])) for line in string.split('\n') if line]

DIR = 0
X = 1
Y = 2

cardinal_points = ['N', 'S', 'E', 'W']
rotation = {'L', 'R'}

def move_ship(instruct, units, position):

	if instruct == 'N':
		position[Y] += units
	elif instruct == 'S':
		position[Y] -= units
	elif instruct == 'E':
		position[X] += units
	elif instruct == 'W':
		position[X] -= units

def rotate_ship(instruct, units, position):
	if instruct == 'R':
		position[DIR] += units
	elif instruct == 'L':
		position[DIR] -= units

	if position[DIR] < 0:
		position[DIR] += 360
	elif position[DIR] > 360:
		position[DIR] -= 360

def advance_ship(instruct, units, position):
	if position[DIR] == 270:
		position[Y] += units
	elif position[DIR] == 90:
		position[Y] -= units
	elif position[DIR] == 0 or position[DIR] == 360:
		position[X] += units
	elif position[DIR] == 180:
		position[X] -= units

def calculate_position(instruct, units, position):
	if instruct in cardinal_points:
		move_ship(instruct, units, position)
	elif instruct in rotation:
		rotate_ship(instruct, units, position)
	elif instruct == 'F':
		advance_ship(instruct, units, position)

def part_1(data):
	"""
	the distance between that location and the ship's starting position
	"""
	position = [0, 0, 0]
	for instruct in data:
		calculate_position(instruct[0], instruct[1], position)
	return print("part 1:", abs(position[X]) + abs(position[Y]))

def part_2(data):
	"""
	"""
	return print("part 2:")

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()


