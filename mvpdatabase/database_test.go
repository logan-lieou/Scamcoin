package mvpdatabase

import (
	"encoding/json"
	"os"
	"testing"
)

// test to see if the hash is working
func testHash(t *testing.T) {
	var gblock *block = genesis_block("logan", "dorian")
	dat, err := os.ReadFile("genesis_block.json")
	if err != nil {
		panic("bugs everywhere!")
	}
	var test *block
	if err := json.Unmarshal(dat, &test); err != nil {
		panic(err)
	}
	if gblock != test {
		t.Errorf("big problem dude %v", gblock.hash)
	}
}
