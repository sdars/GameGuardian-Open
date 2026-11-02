local base = { greet = function(self) return 'hi ' .. self.name end }
local obj = setmetatable({ name = 'bob' }, { __index = base })
print('index-table', obj:greet())

local obj2 = setmetatable({}, { __index = function(t, k) return 'dyn:' .. k end })
print('index-fn', obj2.foo, obj2.bar)

local store = {}
local obj3 = setmetatable({}, { __newindex = function(t, k, v) rawset(t, k, v .. '!') end })
obj3.x = 'v'
print('newindex', obj3.x)

local mt = {
  __add = function(a, b) return 'add' end,
  __sub = function(a, b) return 'sub' end,
  __mul = function(a, b) return 'mul' end,
  __div = function(a, b) return 'div' end,
  __mod = function(a, b) return 'mod' end,
  __pow = function(a, b) return 'pow' end,
  __unm = function(a) return 'unm' end,
  __concat = function(a, b) return 'concat' end,
  __len = function(a) return 99 end,
  __eq = function(a, b) return true end,
  __lt = function(a, b) return true end,
  __le = function(a, b) return true end,
  __tostring = function(a) return 'CUSTOM' end,
  __call = function(self, a) return 'called:' .. tostring(a) end,
  __idiv = function(a, b) return 'idiv' end,
}
local m = setmetatable({}, mt)
print('add', m + 1, 1 + m)
print('sub', m - 1)
print('mul', m * 2)
print('div', m / 2)
print('mod', m % 2)
print('pow', m ^ 2)
print('unm', -m)
print('concat', m .. 'x')
print('len', #m)
print('eq', m == setmetatable({}, mt))
print('lt', m < setmetatable({}, mt), m <= setmetatable({}, mt))
print('tostring', tostring(m))
print('call', m('arg'))
print('idiv', m // 2)

local guarded = setmetatable({}, { __metatable = 'locked' })
print('metatable', getmetatable(guarded))

local inherited = setmetatable({}, { __index = { deep = function() return 'deep' end } })
print('inherit', inherited:deep())

local chained = setmetatable({}, { __index = setmetatable({}, { __index = function() return 'chained' end }) })
print('chain', chained.anything)

local raw = setmetatable({}, { __index = function(t, k) return 'raw:' .. k end, __newindex = function(t, k, v) rawset(t, k, 'N') end })
raw.zz = 'ignored'
print('raw-bypass', raw.zz)
