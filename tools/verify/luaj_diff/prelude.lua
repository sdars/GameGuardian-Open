-- Deterministic serialisation helpers, prepended to every differential test
-- script so that both classpaths observe exactly the same source text.

local function quote(s)
  local r = '"'
  s = tostring(s)
  for i = 1, #s do
    local c = s:sub(i, i)
    if c == '"' then
      r = r .. '\\"'
    elseif c == '\\' then
      r = r .. '\\\\'
    elseif c == '\n' then
      r = r .. '\\n'
    elseif c == '\t' then
      r = r .. '\\t'
    elseif c == '\r' then
      r = r .. '\\r'
    elseif c == '\0' then
      r = r .. '\\0'
    else
      r = r .. c
    end
  end
  return r .. '"'
end

local function dump(v, seen)
  seen = seen or {}
  local t = type(v)
  if t == 'table' then
    if seen[v] then return '<cycle>' end
    seen[v] = true
    local keys = {}
    for k in pairs(v) do keys[#keys + 1] = k end
    table.sort(keys, function(a, b) return tostring(a) < tostring(b) end)
    local parts = { '{' }
    for i = 1, #keys do
      parts[#parts + 1] = tostring(keys[i]) .. '=' .. dump(v[keys[i]], seen)
      parts[#parts + 1] = ','
    end
    parts[#parts + 1] = '}'
    seen[v] = nil
    return table.concat(parts)
  elseif t == 'string' then
    return quote(v)
  else
    return tostring(v)
  end
end

_G.dump = dump
_G.quote = quote

