local out = {}
for i = 1, 10 do
  if i % 2 == 0 then out[#out + 1] = 'e' .. i
  elseif i % 3 == 0 then out[#out + 1] = 't' .. i
  else out[#out + 1] = 'o' .. i end
end
print('if-chain', table.concat(out, ','))

local w = 0
while w < 5 do w = w + 1 if w == 3 then break end end
print('while-break', w)

local r = 0
repeat r = r + 1 until r >= 4
print('repeat', r)

local acc = {}
for i = 10, 1, -2 do acc[#acc + 1] = i end
print('for-step', table.concat(acc, ','))

local fa = {}
for i = 1, 3 do fa[i] = i end
print('for-var', dump(fa))

local function ternary(c) return c and 'yes' or 'no' end
print('ternary', ternary(true), ternary(false), ternary(nil))

local a, b = 1, 2
a, b = b, a
print('swap', a, b)

local t = { 1, 2, 3 }
local x, y = t[1], t[2]
print('multi-assign', x, y)
t[1], t[2] = t[2], t[1]
print('multi-assign2', dump(t))

local n = 5
local msg = n > 3 and 'big' or 'small'
print('and-or', msg)

local count = 0
for i = 1, 100 do
  if i > 50 then break end
  count = count + i
end
print('count', count)

-- goto/label is not part of the luaj grammar: keep the probe isolated so a
-- compile error cannot abort the rest of the file.
local gt, gerr = load('local s = 0\nfor i = 1, 3 do\n  for j = 1, 3 do\n    if j == 2 then goto continue end\n    s = s + i * j\n    ::continue::\n  end\nend\nreturn s')
if gt then print('goto', gt()) else print('goto-unsupported', gerr) end

local neg = -(-5)
local notv = not nil
print('unary', neg, notv, not notv)

local chain = 1 + 2 * 3 ^ 2 - 4 / 2
print('precedence', chain)
print('paren', (1 + 2) * 3)

local long = 1 < 2 and 2 < 3 and 'yes' or 'no'
print('cmp-chain', long)
