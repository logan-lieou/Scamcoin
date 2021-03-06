package main

import (
	"encoding/json"
	"os"
	"github.com/logan-lieou/Scamcoin/mvpdatabase"
)

func main() {
	iblock := genesis_block("logan", "dorian")
	dat, err := json.Marshal(iblock)
	if err != nil {
		panic(err)
	}
	f, err := os.Create("oblock.json")
	if err != nil {
		panic(err)
	}
	defer f.Close()
	f.Write(dat)
}
