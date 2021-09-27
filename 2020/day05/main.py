
#!/usr/bin/env python3

def data_parser(filepath):
	tmp = open(filepath).read()
	return [line for line in tmp.split('\n') if line.strip() != '']

def loop_to_find(data, limit, lower, higher):
	min = 0
	max = limit
	for i in range(len(data)):
		if (data[i] == lower):
			max = min + (max - min)/2
		if (data[i] == higher):
			min = min + (max - min)/2
	return min

def make_list_with_all_id_seats(data):
	all_id_seats = [x * 8 + c for c in range(0, 8) for x in range(0, 128)]
	return (all_id_seats)

def check_row(data):
	return loop_to_find(data, 128, 'F', 'B',)

def check_column(data):
	return loop_to_find(data, 8, 'L', 'R')

def check_seat(data):
	id = []
	for i in range(len(data)):
		row = check_row(data[i][:7])
		column = check_column(data[i][7:])
		id.append(row * 8 + column)
	return id

def part_1(data):
	"""
	the highest seat ID: multiply the row by 8, then add the column
	"""
	seat_id = check_seat(data)
	return print("part 1:", max(seat_id))

def part_2(data):
	"""
	the ID of your seat, the seats with IDs +1 and -1 from yours will be in your list
	"""
	seat_id = check_seat(data)
	all_seats = make_list_with_all_id_seats(data)
	my_id = [x for x in all_seats if x not in seat_id and x+1 in seat_id and x-1 in seat_id][0]
	return print("part 2:", my_id)

def main():
	"""
	run the program by itself, return a tuple of part1 and part2.
	"""
	d = data_parser('input.txt')
	return part_1(d), part_2(d)

if __name__ == "__main__":
	main()
