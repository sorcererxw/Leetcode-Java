package main

import (
	"fmt"
	"hash"
	"hash/maphash"
)

type MyHashMap struct {
	buckets []*Bucket
	count   int
	hasher  hash.Hash64
}

type Bucket struct {
	next  *Bucket
	prev  *Bucket
	value int
	key   int
}

func Constructor() MyHashMap {
	buckets := make([]*Bucket, 1e6)
	for i := range buckets {
		buckets[i] = new(Bucket)
	}
	hasher := &maphash.Hash{}
	hasher.SetSeed(maphash.MakeSeed())
	return MyHashMap{
		buckets: buckets,
		hasher:  hasher,
	}
}

func (m *MyHashMap) loadFactor() float64 {
	return float64(m.count) / float64(len(m.buckets))
}

func (m *MyHashMap) hash(key int) int {
	return key % len(m.buckets)
}

func (m *MyHashMap) print() {
	for i, b := range m.buckets {
		item := b.next
		fmt.Printf("%2d - ", i)
		for item != nil {
			fmt.Printf("%d:%d ", item.key, item.value)
			item = item.next
		}
		fmt.Println()
	}
}

func (m *MyHashMap) Put(key int, value int) {
	head := m.buckets[m.hash(key)]
	{
		bucket := head.next
		for bucket != nil {
			if bucket.key == key {
				bucket.value = value
				return
			}
			bucket = bucket.next
		}
	}
	m.count++
	b := &Bucket{
		value: value,
		key:   key,
	}
	if head.next != nil {
		b.next = head.next
		head.next.prev = b
	}
	b.prev = head
	head.next = b
}

func (m *MyHashMap) Get(key int) int {
	head := m.buckets[m.hash(key)]
	bucket := head.next
	for bucket != nil {
		if bucket.key == key {
			return bucket.value
		}
		bucket = bucket.next
	}
	return -1
}

func (m *MyHashMap) Remove(key int) {
	head := m.buckets[m.hash(key)]
	bucket := head.next
	for bucket != nil {
		if bucket.key == key {
			break
		}
		bucket = bucket.next
	}
	if bucket == nil {
		return
	}
	m.count--
	bucket.prev.next = bucket.next
	if bucket.next != nil {
		bucket.next.prev = bucket.prev
	}
}
