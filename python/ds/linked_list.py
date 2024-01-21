from dataclasses import dataclass
from typing import TypeVar

Node = TypeVar("Node")


@dataclass
class Node:
    data: int
    left: Node
    right: Node
