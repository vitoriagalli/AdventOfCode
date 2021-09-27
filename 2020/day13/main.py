#!/usr/bin/env python3

def data_parser(filepath):
	string = open(filepath).read()
	data = [line for line in string.split('\n') if line]
	earliest_timestamp = int(data[0])
	bus_list = [[i, number] for i, number in enumerate(data[1].split(','))]
	return [earliest_timestamp, bus_list]

def earliest_bus(timestamp, bus_list):
	while True:
		for bus in bus_list:
			if not timestamp % bus:
				return (bus, timestamp)
		timestamp += 1
	return False

def multiply(bus_list):
	prod = 1
	for num, id in bus_list:
		prod *= id
	return prod

def earliest_timestamp_offset(bus_list):
	t = bus_list[0][1]
	for (index, [num, id]) in enumerate(bus_list):
		while (t + num) % id:
			t += multiply(bus_list[:index])
	return t

def part_1(data):
	"""
	the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus
	"""
	bus_list = [int(n) for i, n in data[1] if n != 'x']
	bus, timestamp = earliest_bus(data[0], bus_list)
	return print("part 1:", (timestamp - data[0]) * bus)

def part_2(data):
	"""
	the  earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list
	"""
	bus_list = [[i, int(n)] for i, n in data[1] if n != 'x']
	return print("part 2:", earliest_timestamp_offset(bus_list))

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()

