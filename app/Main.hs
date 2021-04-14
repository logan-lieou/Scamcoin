module Main where

import qualified Crypto.Hash.SHA256 as SHA256
import qualified Data.ByteString

data Block 
    = Data String
    | Hash String
    | PrevHash String 
    | Block Data Hash PrevHash
    deriving(Show, Eq)

firstBlock :: Data -> Block
firstBlock input
    = Block input hash ""
    where
        hash = SHA256.finalize ctx
        ctx  = foldl SHA256.update ctx0 (map Data.ByteString.pack [ [1, 2, 3], [4, 5, 6] ])
        ctx0 = SHA256.init

main :: IO ()
main = do
    let x = Block "a" "b" "c"

    print x

