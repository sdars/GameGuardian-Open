-- compiler-focused coverage: scoping, register allocation, constant folding,
-- nested protos, upvalue sharing, long jumps and multi-return interaction.
local a = 1
local b = 'two'
local c = { 3 }
local function use_all() return a, b, c[1] end
print('scope', use_all())

do
  local a = 'shadow'
  print('shadow', a)
end
print('after-block', a)

local function multi()
  local x, y, z = 1, 2, 3
  return x + y + z, x, y, z
end
print('multi-local', multi())

local function upv()
  local n = 0
  local function inc() n = n + 1 end
  local function get() return n end
  inc(); inc()
  return get(), n
end
print('upvalue-share', upv())

local function constfold() return 2 + 3 * 4, 'a' .. 'b', 10 / 2 end
print('constfold', constfold())

local function longjump(n)
  if n == 1 then return 'one' end
  if n == 2 then return 'two' end
  if n == 3 then return 'three' end
  if n == 4 then return 'four' end
  if n == 5 then return 'five' end
  if n == 6 then return 'six' end
  return 'many'
end
local j = {}
for i = 1, 8 do j[#j + 1] = longjump(i) end
print('longjump', table.concat(j, ','))

local function nested3()
  local function l2()
    local function l3() return 'deep' end
    return l3()
  end
  return l2()
end
print('nested3', nested3())

local function tailcalls(n) if n <= 0 then return 0 end return tailcalls(n - 1) end
print('recursion', tailcalls(100))

local function cond_expr(a) return (a > 0) and (a > 10 and 'big' or 'mid') or 'neg' end
print('cond', cond_expr(-1), cond_expr(5), cond_expr(50))

local function vararg_sum(...) local s = 0 for _, v in ipairs({ ... }) do s = s + v end return s end
print('vararg-sum', vararg_sum(1, 2, 3, 4, 5))

local function returns_table() return { 1, 2, 3 } end
print('returns-table', dump(returns_table()))

local function nested_call() return (returns_table())[2] end
print('nested-call', nested_call())

local t = {}
function t:m(k) return k end
print('method-expr', t:m('v'), (t:m)('v'))

local s1 = 'x'
print('index-expr', s1:upper():lower():len())
print('paren-call', (#'abc'), (-2 ^ 2), (-(2 ^ 2)))

local function manyargs(a, b, c, d, e, f, g, h, i, j)
  return a + b + c + d + e + f + g + h + i + j
end
print('manyargs', manyargs(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

local num = 0x7fffffff
print('hex', num, 0xffffffff, 0x100)
print('exp', 1e3, 1E3, 1e+3, .5, 5.)
print('escapes', '\65\066\9', '\n\t')

local function selfref()
  local t = {}
  t.me = t
  return t
end
print('selfref', dump(selfref()))
