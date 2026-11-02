local t = { 1, 2, 3, x = 'a', ['y z'] = 'b' }
print('len', #t)
print('dump', dump(t))
table.insert(t, 4)
print('insert-end', dump(t))
table.insert(t, 1, 0)
print('insert-begin', dump(t))
print('remove-end', table.remove(t), dump(t))
print('remove-mid', table.remove(t, 1), dump(t))
local s = { 5, 3, 1, 4, 2 }
table.sort(s)
print('sort', table.concat(s, ','))
table.sort(s, function(a, b) return a > b end)
print('sort-cmp', table.concat(s, ','))
local st = { { 3, 'c' }, { 1, 'a' }, { 2, 'b' } }
table.sort(st, function(a, b) return a[1] < b[1] end)
print('sort-table', dump(st))
print('unpack', table.unpack({ 1, 2, 3 }))
print('unpack-range', table.unpack({ 1, 2, 3, 4 }, 2, 3))
local p = table.pack(1, nil, 3)
print('pack', dump(p))
local nested = { a = { b = { c = 'deep' } } }
print('nested', nested.a.b.c, nested['a']['b']['c'])
local acc = {}
for i = 1, 5 do acc[i] = i * i end
print('numeric-for', dump(acc))
local keys = {}
for k in pairs({ x = 1, y = 2, z = 3 }) do keys[#keys + 1] = k end
table.sort(keys)
print('pairs', table.concat(keys, ','))
local ip = {}
for i, v in ipairs({ 'a', 'b', 'c' }) do ip[#ip + 1] = i .. v end
print('ipairs', table.concat(ip, ','))
print('rawget', rawget(nested, 'a') ~= nil, rawget({ 1, 2 }, 1))
local rt = {}
rawset(rt, 'k', 'v')
print('rawset', rt.k, rawlen(rt))
print('rawequal', rawequal(rt, rt), rawequal(rt, {}))
local moved = table.move({ 1, 2, 3, 4, 5 }, 2, 4, 1, {})
print('move', dump(moved))
print('concat-nested', table.concat({ { 'a', 'b' }, { 'c' } }, '|'))
local q = {}
q[#q + 1] = 'x'
q[#q + 1] = 'y'
print('q', dump(q))
