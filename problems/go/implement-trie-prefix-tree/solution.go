package main

type Trie struct {
	child [26]*Trie
	end   bool
}

func Constructor() Trie {
	return Trie{}
}

func (t *Trie) Insert(word string) {
	n := t
	for _, c := range word {
		i := c - 'a'
		if n.child[i] == nil {
			n.child[i] = &Trie{}
		}
		n = n.child[i]
	}
	n.end = true
}

func (t *Trie) searchNode(word string) *Trie {
	n := t
	for _, c := range word {
		i := c - 'a'
		if n.child[i] == nil {
			return nil
		}
		n = n.child[i]
	}
	return n
}

func (t *Trie) Search(word string) bool {
	n := t.searchNode(word)
	return n != nil && n.end
}

func (t *Trie) StartsWith(prefix string) bool {
	return t.searchNode(prefix) != nil
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
