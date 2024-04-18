# This tps them back too the overworked with there exact pos
execute in minecraft:overworld run tp @p ~ 320 ~
execute at @a[nbt={Dimension:"minecraft:overworld"}] if block ^ ^ ^ #minecraft:sculk_replaceable_world_gen run execute in shit:backrooms run playsound shit:fall_into_backrooms master @p[nbt={Dimension:"shit:backrooms"}] ~ ~1 ~ 1 1
