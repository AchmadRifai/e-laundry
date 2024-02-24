package recoveries

import (
	"log"
	"runtime/debug"
)

func NormalError() {
	if r := recover(); r != nil {
		log.Println("", r)
		log.Println(string(debug.Stack()))
	}
}
