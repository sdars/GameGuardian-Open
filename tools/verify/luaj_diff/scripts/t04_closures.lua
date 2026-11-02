local function counter()
  local n = 0
  return function() n = n + 1 return n end
end
local c1, c2 = counter(), counter()
print('closure', c1(), c1(), c2())

local function outer()
  local x = 1
  local function inner()
    x = x + 1
    return x
  end
  return inner, function() return x end
end
local inc, get = outer()
inc()
print('upvalue', get())

local function varargs(...)
  local n = select('#', ...)
  local t = { ... }
  return n, dump(t)
end
print('varargs', varargs(1, 2, 3))
print('varargs-empty', varargs())
print('varargs-nil', varargs(1, nil, 3))

local function tail(a, b, ...)
  return a + b, ...
end
print('tail', tail(1, 2, 3, 4))

local function multi()
  return 1, 2, 3
end
local x, y, z = multi()
print('multi', x, y, z)
print('multi-paren', (multi()))
print('multi-mid', multi(), 9)

local function fib(n)
  if n < 2 then return n end
  return fib(n - 1) + fib(n - 2)
end
print('fib', fib(15))

local obj = { n = 5 }
function obj.get() return self.n end
function obj.add(k) self.n = self.n + k return self end
print('method', obj:get(), obj:add(3):get())

local obj2 = {}
obj2.__index = obj2
function obj2.new(v) return setmetatable({ v = v }, obj2) end
function obj2:val() return self.v end
print('oop', obj2.new(7):val())

local fns = {}
for i = 1, 3 do
  fns[i] = function() return i end
end
print('loop-capture', fns[1](), fns[2](), fns[3]())

local shared = 0
local function bump() shared = shared + 1 end
bump(); bump()
print('shared', shared)

local function pass(...) return ... end
print('pass-through', pass(1, 'two', true, nil, 5))
