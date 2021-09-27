#!/usr/bin/env python3
import re
import json

def data_parser(filepath):
	'''
	convert file info (string) to dict.
	'''
	string = open(filepath).read()
	string = string.replace(" bags contain no other bags", "")
	string = string.replace(" bags contain", ":")
	string = string.replace(" bags", "")
	string = string.replace(" bag", "")
	string = re.sub(r'([a-z]+[ ][a-z]+)([:]) ', r'\1: {', string)
	string = re.sub(r'([0-9]+)[ ]([a-z]+[ ][a-z]+)', r'\2 : \1', string)
	string = re.sub(r'([0-9])[.][\n]', r'\1}, ', string)
	string = re.sub(r'([a-z]+[ ][a-z]+)', r'"\1"', string)
	string = string.replace(".\n", ": {}, ")
	string = re.sub(r'[,][ ]+$', r'}', string)
	string = '{' + string
	data = json.loads(string)
	return data

def look_for_bigger_bag(bag_to_find, data):
	bags_contain = []
	for key in data:
		for bag in data[key]:
			if bag == bag_to_find:
				bags_contain.append(key)
	return(bags_contain)

def look_for_smaller_bag(bag_to_find, data):
	bags_contain = []
	for key in data:
		if key == bag_to_find:
			bags_contain.append(key)
	return(bags_contain)

def part_1(data):
	"""
	how many bag colors can eventually contain at least one shiny gold bag
	"""
	all_biger_bags = []
	bags_to_find = ["shiny gold"]
	while 1:
		if not bags_to_find:
			break
		bigger_bags = []
		for bag in bags_to_find:
			list = look_for_bigger_bag(bag, data)
			for item in list:
				if item not in all_biger_bags and item not in bigger_bags:
					bigger_bags.append(item)
		all_biger_bags += bigger_bags
		bags_to_find = bigger_bags
	return (print("part 1:", len(all_biger_bags)))

def part_2(data):
	"""
	how many individual bags are required inside your single shiny gold bag?
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
