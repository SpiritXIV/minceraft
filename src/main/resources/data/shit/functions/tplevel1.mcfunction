# This tps them back too the backroomsone with there exact pos
execute as @a[nbt={Dimension:"shit:backrooms"}] at @s if block ~ ~-1 ~ shit:backrooms_floor_teleport run execute in shit:backroomsone run tp ~ 20 ~
playsound shit:fall_into_backrooms master @a[nbt={Dimension:"shit:backroomsone"}] ~ ~ ~ 1 1
