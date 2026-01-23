class Solution:
    def __init__(self):
        self.curr = []
        self.buffer = []
        
    def append(self, x):
        self.curr.append(x)

    def undo(self):
        self.buffer.append(self.curr.pop())

    def redo(self):
        self.curr.append(self.buffer.pop())

    def read(self):
        return ''.join(self.curr)