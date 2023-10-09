# This tries to prevent players dying from fall-damage when they first enter the Backrooms.
execute as @a at @s if entity @s[y=-65,dy=-2000] run tag @s add EnterBR
execute as @a[tag=EnterBRO] at @s in shit:backroomstwo run tp @s ~ 20 ~
execute as @a[tag=EnterBRO] run effect give @s minecraft:slow_falling 10 0 true
execute as @a[tag=EnterBRO] run tag @s remove EnterBRO
# Rarely, a player will spawn in above the top of the map, this tries to correct that.
execute as @a[nbt={Dimension:"shit:backroomstwo"},gamemode=!spectator,gamemode=!creative] at @s if entity @s[y=60,dy=68] run tp @s ~ 20 ~
# Sometimes a player will spawn in walls, or an area without backrooms, this tries to move them till they're in an open hallway.
execute as @a[nbt={Dimension:"shit:backroomstwo"},gamemode=!spectator] at @s if block ~ ~ ~ shit:backrooms_wetted_concrete_wall run tp @s ~4 ~ ~
# This section makes the flickering lights work.
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ air run setblock ~ ~ ~ light[level=0]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=1] run setblock ~ ~-1 ~ light[level=0]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=2] run setblock ~ ~-1 ~ light[level=1]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=3] run setblock ~ ~-1 ~ light[level=2]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=4] run setblock ~ ~-1 ~ light[level=3]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=5] run setblock ~ ~-1 ~ light[level=4]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=6] run setblock ~ ~-1 ~ light[level=5]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=7] run setblock ~ ~-1 ~ light[level=6]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=8] run setblock ~ ~-1 ~ light[level=7]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=9] run setblock ~ ~-1 ~ light[level=8]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=10] run setblock ~ ~-1 ~ light[level=9]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=11] run setblock ~ ~-1 ~ light[level=10]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=12] run setblock ~ ~-1 ~ light[level=11]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=13] run setblock ~ ~-1 ~ light[level=12]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=14] run setblock ~ ~-1 ~ light[level=13]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=15] run setblock ~ ~-1 ~ light[level=14]
# randomly decides when to flicker, sometimes with a double flash.
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=11] if predicate shit:flicker2_r run setblock ~ ~-1 ~ light[level=15]
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=0] if predicate shit:flicker2_r run setblock ~ ~-1 ~ light[level=15]
# plays a couple notes which together sorta sound like a fluorescent bulb flickering.
execute as @e[type=marker,tag=flicker2] at @s if block ~ ~-1 ~ light[level=15] in shit:backroomstwo run playsound shit:light_flicker master @a[nbt={Dimension:"shit:backroomstwo"}] ~ ~ ~ 0.2 0.8
execute as @e[type=marker,tag=flicker2] at @s anchored eyes if block ~ ~-1 ~ light[level=15] in shit:backroomstwo run particle minecraft:flame ^ ^1 ^ 0 0 0 0.1 2 force @a
execute as @e[type=marker,tag=flicker2] at @s anchored eyes if block ~ ~-1 ~ light[level=15] in shit:backroomstwo run particle minecraft:ash ^ ^1 ^ 0 0 0 2 10 force @a
# removes the invisible light block and marker entity, if the block no longer exists.
execute as @e[type=marker,tag=flicker2] at @s unless block ~ ~ ~ shit:backrooms_industrial_light_shattered run setblock ~ ~-1 ~ air
execute as @e[type=marker,tag=flicker2] at @s unless block ~ ~ ~ shit:backrooms_industrial_light_shattered run kill @s
# TP the player to the next level
# execute at @a[nbt={Dimension:"shit:backroomstwo"}] if block ~ ~-1 ~ shit:backrooms_concrete_floor_teleport run function shit:tplevel2