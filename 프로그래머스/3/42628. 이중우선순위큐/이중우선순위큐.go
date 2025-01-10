package main

import (
	"container/heap"
	"strconv"
	"strings"
)

type MinHeap []int
type MaxHeap []int

func (h MinHeap) Len() int           { return len(h) }
func (h MinHeap) Less(i, j int) bool { return h[i] < h[j] }
func (h MinHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *MinHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i] > h[j] } // Reverse order for max heap
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }
func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}
func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func solution(operations []string) []int {
	minHeap := &MinHeap{}
	maxHeap := &MaxHeap{}
	heap.Init(minHeap)
	heap.Init(maxHeap)
	count := make(map[int]int) // Count to manage frequency of elements

	for _, operation := range operations {
		parts := strings.Split(operation, " ")
		command := parts[0]
		number, _ := strconv.Atoi(parts[1])

		if command == "I" {
			heap.Push(minHeap, number)
			heap.Push(maxHeap, number)
			count[number]++
		} else if command == "D" {
			if len(*minHeap) == 0 || len(*maxHeap) == 0 {
				continue
			}
			if number == 1 { // Remove max
				for len(*maxHeap) > 0 {
					max := heap.Pop(maxHeap).(int)
					if count[max] > 0 {
						count[max]--
						break
					}
				}
			} else { // Remove min
				for len(*minHeap) > 0 {
					min := heap.Pop(minHeap).(int)
					if count[min] > 0 {
						count[min]--
						break
					}
				}
			}
		}
	}

	// Cleanup to find valid min and max
	var min, max int
	for len(*minHeap) > 0 {
		min = heap.Pop(minHeap).(int)
		if count[min] > 0 {
			break
		}
	}
	for len(*maxHeap) > 0 {
		max = heap.Pop(maxHeap).(int)
		if count[max] > 0 {
			break
		}
	}

	// If heaps are empty
	if len(count) == 0 || count[min] == 0 || count[max] == 0 {
		return []int{0, 0}
	}
	return []int{max, min}
}
