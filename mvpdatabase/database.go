package mvpdatabase

import (
	"crypto/sha256"
	"fmt"
	"time"
)

type transaction struct {
	value int    `json: "value"`
	from  string `json: "from"`
	to    string `json: "to"`
}

type block struct {
	hash  string      `json: "hash"`
	date  time.Time   `json: "date"`
	money transaction `json: "transaction"`
}

func genesis_block(creator string, cofounder string) *block {
	var date time.Time = time.Now()
	var genesis_hash = sha256.Sum256([]byte("original hash"))
	var b *block = &block{
		hash: fmt.Sprintf("%x", genesis_hash[:]),
		date: date,
		money: transaction{
			value: 999,
			from:  creator,
			to:    cofounder,
		},
	}
	return b
}
