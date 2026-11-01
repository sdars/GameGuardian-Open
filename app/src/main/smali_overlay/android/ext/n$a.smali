.method static a(Landroid/ext/n;JLjava/lang/String;I)I
    .locals 26

    .line 1
    move-object/from16 v6, p0

    new-instance v7, Landroid/ext/n$d;

    move-object/from16 v8, p3

    invoke-direct {v7, v8}, Landroid/ext/n$d;-><init>(Ljava/lang/String;)V

    iput-object v7, v6, Landroid/ext/n;->f1081c:Landroid/ext/n$d;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    move-object/from16 v3, p3

    move/from16 v5, p4

    invoke-static/range {v0 .. v5}, Landroid/ext/n$c;->a(Landroid/ext/n;JLjava/lang/String;ZI)I

    move-result v0

    const/4 v9, -0x1

    if-eq v0, v9, :cond_0

    return v0

    :cond_0
    const/4 v4, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    move-object/from16 v3, p3

    move/from16 v5, p4

    invoke-static/range {v0 .. v5}, Landroid/ext/n$e;->a(Landroid/ext/n;JLjava/lang/String;ZI)I

    move-result v0

    if-eq v0, v9, :cond_1

    return v0

    :cond_1
    sget-object v0, Landroid/ext/n$a;->f1082a:[I

    sget-object v1, Landroid/ext/n$a;->f1083b:[Ljava/lang/String;

    array-length v2, v1

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v2, :cond_a1

    mul-int/lit8 v5, v4, 0x2

    aget v8, v0, v5

    invoke-virtual {v7}, Landroid/ext/n$d;->k()V

    :try_start_0
    aget-object v10, v1, v4

    add-int/lit8 v11, v5, 0x1

    aget v11, v0, v11

    if-nez v11, :cond_2

    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    goto/16 :goto_3d

    :cond_2
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v12

    const/4 v13, 0x0

    const/4 v14, -0x1

    :goto_1
    const/16 v15, 0x20

    if-ge v13, v12, :cond_5

    invoke-static {v10, v12, v13}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v9
    :try_end_0
    .catch Landroid/ext/n$f; {:try_start_0 .. :try_end_0} :catch_7

    if-gt v9, v15, :cond_4

    :goto_2
    if-ge v13, v12, :cond_3

    add-int/lit8 v9, v13, 0x1

    :try_start_1
    invoke-static {v10, v12, v9}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v3

    if-gt v3, v15, :cond_3

    move v13, v9

    goto :goto_2

    :catch_0
    nop

    move-object/from16 v24, v0

    move-object/from16 v23, v1

    goto/16 :goto_9

    :cond_3
    const/16 v9, 0x20

    :cond_4
    const/16 v3, 0x25

    if-eq v9, v3, :cond_9

    const/16 v3, 0x3b

    if-ne v9, v3, :cond_6

    :cond_5
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    const/16 v0, 0x20

    goto/16 :goto_3a

    :cond_6
    const/16 v3, 0x61

    if-gt v3, v9, :cond_7

    const/16 v3, 0x7a

    if-gt v9, v3, :cond_7

    add-int/lit8 v9, v9, -0x20

    int-to-char v9, v9

    :cond_7
    invoke-virtual {v7, v9}, Landroid/ext/n$d;->a(C)Z

    move-result v3
    :try_end_1
    .catch Landroid/ext/n$f; {:try_start_1 .. :try_end_1} :catch_0

    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    if-nez v3, :cond_8

    goto/16 :goto_3c

    :cond_8
    :goto_3
    const/4 v0, 0x1

    goto/16 :goto_39

    :cond_9
    add-int/lit8 v13, v13, 0x1

    :try_start_2
    invoke-static {v10, v12, v13}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v3
    :try_end_2
    .catch Landroid/ext/n$f; {:try_start_2 .. :try_end_2} :catch_7

    const/16 v9, 0x25

    if-eq v3, v9, :cond_99

    const/16 v9, 0x45

    if-eq v3, v9, :cond_94

    const-string v9, ", "

    const/high16 v16, 0x200000

    const/high16 v18, 0x1000000

    const/high16 v19, 0x800000

    const/high16 v20, 0x2000000

    const/16 v15, 0x50

    if-eq v3, v15, :cond_76

    const/16 v15, 0x65

    if-eq v3, v15, :cond_75

    const/16 v15, 0x6d

    const/16 v21, 0x2

    if-eq v3, v15, :cond_6f

    const/16 v15, 0x42

    if-eq v3, v15, :cond_67

    const/16 v15, 0x43

    const/high16 v22, 0x400000

    if-eq v3, v15, :cond_5e

    const/16 v15, 0x52

    if-eq v3, v15, :cond_5c

    const/16 v15, 0x53

    move-object/from16 v23, v1

    const/16 v1, 0xf

    if-eq v3, v15, :cond_3a

    const/16 v15, 0x55

    if-eq v3, v15, :cond_3d

    const/16 v15, 0x56

    if-eq v3, v15, :cond_3b

    const/16 v15, 0x73

    if-eq v3, v15, :cond_3a

    const/16 v15, 0x74

    if-eq v3, v15, :cond_39

    packed-switch v3, :pswitch_data_0

    packed-switch v3, :pswitch_data_1

    packed-switch v3, :pswitch_data_2

    :try_start_3
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "81 Invalid format char \'"

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const-string v3, "\'; "

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, "; "

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v3, "; \'"

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\'"

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    :catch_1
    nop

    goto :goto_8

    :pswitch_0
    const/4 v15, 0x0

    invoke-static {v8, v7, v15}, Landroid/ext/n;->l(ILandroid/ext/n$d;Z)I

    move-result v1

    :goto_4
    move-object/from16 v24, v0

    move v8, v1

    move/from16 p3, v2

    goto/16 :goto_3

    :pswitch_1
    const/4 v15, 0x0

    const-string v1, "PLS"

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_d

    const-string v1, "PLT"

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_d

    const-string v1, "PLE"

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    goto :goto_6

    :cond_a
    const-string v1, "PL"

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c

    iget v1, v7, Landroid/ext/n$d;->f1090c:I

    add-int/lit8 v1, v1, -0x2

    iput v1, v7, Landroid/ext/n$d;->f1090c:I

    :cond_b
    move-object/from16 v24, v0

    move/from16 p3, v2

    move/from16 v25, v14

    goto/16 :goto_15

    :cond_c
    :goto_5
    const/16 v1, 0x50

    goto :goto_7

    :cond_d
    :goto_6
    iget v1, v7, Landroid/ext/n$d;->f1090c:I

    add-int/lit8 v1, v1, -0x3

    iput v1, v7, Landroid/ext/n$d;->f1090c:I

    goto :goto_5

    :goto_7
    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1
    :try_end_3
    .catch Landroid/ext/n$f; {:try_start_3 .. :try_end_3} :catch_1

    if-eqz v1, :cond_b

    const v1, 0xf000

    or-int/2addr v1, v8

    goto :goto_4

    :pswitch_2
    const/16 v1, 0x23

    const/4 v15, 0x0

    :try_start_4
    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1
    :try_end_4
    .catch Landroid/ext/n$f; {:try_start_4 .. :try_end_4} :catch_4

    if-eqz v1, :cond_13

    and-int v1, v11, v20

    if-eqz v1, :cond_e

    and-int v1, v8, v20

    if-nez v1, :cond_e

    :goto_8
    move-object/from16 v24, v0

    :goto_9
    move/from16 p3, v2

    goto/16 :goto_3c

    :cond_e
    or-int v8, v8, v20

    move/from16 p3, v2

    :try_start_5
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v1

    long-to-int v2, v1

    invoke-virtual {v7, v9}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1
    :try_end_5
    .catch Landroid/ext/n$f; {:try_start_5 .. :try_end_5} :catch_3

    if-eqz v1, :cond_10

    move-object/from16 v24, v0

    :try_start_6
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    and-int/lit8 v0, v1, -0x1f

    if-nez v0, :cond_f

    and-int/lit16 v0, v2, -0x100

    if-eqz v0, :cond_11

    :cond_f
    move v14, v13

    goto :goto_c

    :catch_2
    :goto_a
    nop

    goto/16 :goto_3c

    :cond_10
    move-object/from16 v24, v0

    const/16 v0, 0x20

    const/4 v1, 0x0

    :goto_b
    if-ge v1, v0, :cond_9f

    shl-int v0, v2, v1

    rsub-int/lit8 v3, v1, 0x20

    shr-int v3, v2, v3

    or-int/2addr v0, v3

    const/16 v3, 0xff

    if-gt v0, v3, :cond_12

    move v2, v0

    :cond_11
    :goto_c
    shl-int/lit8 v0, v1, 0x7

    or-int/2addr v0, v2

    :goto_d
    or-int/2addr v0, v8

    :goto_e
    move v8, v0

    goto/16 :goto_3

    :cond_12
    add-int/lit8 v1, v1, 0x2

    const/16 v0, 0x20

    goto :goto_b

    :catch_3
    move-object/from16 v24, v0

    goto :goto_a

    :cond_13
    move-object/from16 v24, v0

    move/from16 p3, v2

    const/4 v0, 0x1

    invoke-static {v8, v7, v0}, Landroid/ext/n;->l(ILandroid/ext/n$d;Z)I

    move-result v1

    and-int v0, v1, v20

    if-eqz v0, :cond_14

    :goto_f
    move v8, v1

    :goto_10
    move v14, v13

    goto/16 :goto_3

    :cond_14
    :goto_11
    move v8, v1

    goto/16 :goto_3

    :catch_4
    move-object/from16 v24, v0

    :goto_12
    move/from16 p3, v2

    goto :goto_a

    :pswitch_3
    move-object/from16 v24, v0

    move/from16 p3, v2

    const/4 v15, 0x0

    sget-object v0, Landroid/ext/n;->f1075d:[Ljava/lang/String;

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v0

    const/4 v2, -0x1

    if-ne v0, v2, :cond_15

    goto/16 :goto_3c

    :cond_15
    if-le v0, v1, :cond_16

    const/16 v0, 0xe

    :cond_16
    shl-int/lit8 v0, v0, 0x1c

    goto :goto_d

    :pswitch_4
    move-object/from16 v24, v0

    move/from16 p3, v2

    const/4 v15, 0x0

    const/16 v0, 0x2b

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_17

    const/4 v0, 0x1

    goto :goto_13

    :cond_17
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_18

    const/4 v0, -0x1

    goto :goto_13

    :cond_18
    const/4 v0, 0x0

    :goto_13
    const-string v1, "0X"

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_19

    goto/16 :goto_3c

    :cond_19
    invoke-virtual {v7}, Landroid/ext/n$d;->f()J

    move-result-wide v1

    move/from16 v25, v14

    if-eqz v0, :cond_1a

    int-to-long v14, v0

    mul-long v14, v14, v1

    add-long v1, p1, v14

    :cond_1a
    sub-long v1, v1, p1

    long-to-int v0, v1

    add-int/lit8 v0, v0, -0x8

    shr-int/lit8 v0, v0, 0x2

    add-int v0, v0, v19

    xor-int v0, v0, v19

    const v1, 0xffffff

    and-int/2addr v1, v0

    or-int/2addr v1, v8

    const/high16 v2, -0x1000000

    and-int/2addr v0, v2

    if-eqz v0, :cond_1b

    goto :goto_f

    :cond_1b
    :goto_14
    move v8, v1

    :cond_1c
    :goto_15
    move/from16 v14, v25

    goto/16 :goto_3

    :pswitch_5
    move-object/from16 v24, v0

    :goto_16
    move/from16 p3, v2

    move/from16 v25, v14

    goto/16 :goto_32

    :pswitch_6
    move-object/from16 v24, v0

    move/from16 p3, v2

    move/from16 v25, v14

    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    const/4 v0, -0x1

    invoke-static {v10, v12, v13, v6, v0}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    move-result v1

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->c(Landroid/ext/n;)I

    move-result v0

    invoke-static {v10, v12, v1}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v2

    const/16 v3, 0x27

    if-eq v2, v3, :cond_32

    const/16 v3, 0x3f

    if-eq v2, v3, :cond_2e

    const/16 v3, 0x52

    if-eq v2, v3, :cond_29

    const/16 v3, 0x54

    if-eq v2, v3, :cond_29

    const/16 v3, 0x60

    if-eq v2, v3, :cond_32

    const/16 v3, 0x62

    if-eq v2, v3, :cond_26

    const/16 v3, 0x64

    if-eq v2, v3, :cond_25

    const/16 v3, 0x72

    if-eq v2, v3, :cond_29

    const/16 v3, 0x78

    if-eq v2, v3, :cond_22

    const/16 v3, 0x57

    if-eq v2, v3, :cond_21

    const/16 v0, 0x58

    if-ne v2, v0, :cond_20

    invoke-virtual {v7}, Landroid/ext/n$d;->d()C

    move-result v0

    const/16 v2, 0x30

    if-lt v0, v2, :cond_1d

    const/16 v3, 0x39

    if-le v0, v3, :cond_1e

    :cond_1d
    const/16 v3, 0x41

    if-lt v0, v3, :cond_9f

    const/16 v3, 0x46

    if-le v0, v3, :cond_1e

    goto/16 :goto_3c

    :cond_1e
    if-lt v0, v2, :cond_1f

    const/16 v2, 0x39

    if-gt v0, v2, :cond_1f

    add-int/lit8 v0, v0, -0x30

    goto :goto_17

    :cond_1f
    add-int/lit8 v0, v0, -0x37

    :goto_17
    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v0}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    :goto_18
    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v0

    move v8, v0

    move v13, v1

    goto :goto_15

    :cond_20
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "71 Invalid format char \'"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    const-string v2, "\'; "

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v2, "; "

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "; \'"

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\'"

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_21
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v2

    long-to-int v3, v2

    const/4 v2, 0x1

    sub-int/2addr v3, v2

    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v3}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v8

    shl-int v0, v2, v0

    sub-int/2addr v0, v2

    not-int v0, v0

    and-int/2addr v0, v3

    move v13, v1

    if-eqz v0, :cond_1c

    goto/16 :goto_10

    :cond_22
    const-string v2, "0X"

    invoke-virtual {v7, v2}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_23

    goto/16 :goto_3c

    :cond_23
    invoke-virtual {v7}, Landroid/ext/n$d;->f()J

    move-result-wide v2

    long-to-int v3, v2

    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v3}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v2

    const/4 v8, 0x1

    shl-int v0, v8, v0

    sub-int/2addr v0, v8

    not-int v0, v0

    and-int/2addr v0, v3

    if-eqz v0, :cond_24

    :goto_19
    move v13, v1

    move v14, v13

    move v8, v2

    goto/16 :goto_3

    :cond_24
    move v13, v1

    :goto_1a
    move v8, v2

    goto/16 :goto_15

    :cond_25
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v2

    long-to-int v3, v2

    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v3}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v2

    const/4 v8, 0x1

    shl-int v0, v8, v0

    sub-int/2addr v0, v8

    not-int v0, v0

    and-int/2addr v0, v3

    if-eqz v0, :cond_24

    goto :goto_19

    :cond_26
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v2

    long-to-int v3, v2

    and-int/lit8 v2, v3, 0x7

    if-eqz v2, :cond_27

    move v14, v1

    goto :goto_1b

    :cond_27
    move/from16 v14, v25

    :goto_1b
    shr-int/lit8 v2, v3, 0x3

    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v2}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v3

    const/4 v8, 0x1

    shl-int v0, v8, v0

    sub-int/2addr v0, v8

    not-int v0, v0

    and-int/2addr v0, v2

    move v13, v1

    if-eqz v0, :cond_28

    move v14, v13

    :cond_28
    move v8, v3

    goto/16 :goto_3

    :cond_29
    sget-object v0, Landroid/ext/n;->f1076e:[Ljava/lang/String;

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v0

    const/4 v3, -0x1

    if-ne v0, v3, :cond_2a

    goto/16 :goto_3c

    :cond_2a
    const/16 v3, 0x54

    if-ne v2, v3, :cond_2b

    add-int/lit8 v0, v0, -0x1

    :cond_2b
    add-int/lit8 v2, v1, 0x1

    invoke-static {v10, v12, v2}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v3

    const/16 v9, 0x75

    if-ne v3, v9, :cond_2c

    move v1, v2

    :cond_2c
    add-int/lit8 v2, v1, 0x1

    invoke-static {v10, v12, v2}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v3

    const/16 v9, 0x55

    if-ne v3, v9, :cond_2d

    move v1, v2

    :cond_2d
    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v0}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    goto/16 :goto_18

    :cond_2e
    invoke-virtual {v7}, Landroid/ext/n$d;->d()C

    move-result v2

    const/4 v3, 0x1

    shl-int v0, v3, v0

    const/4 v3, 0x0

    :goto_1c
    if-ge v3, v0, :cond_30

    add-int v9, v1, v0

    sub-int/2addr v9, v3

    invoke-static {v10, v12, v9}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v9

    if-ne v9, v2, :cond_2f

    const/4 v2, -0x1

    goto :goto_1d

    :cond_2f
    add-int/lit8 v3, v3, 0x1

    goto :goto_1c

    :cond_30
    const/4 v2, -0x1

    const/4 v3, -0x1

    :goto_1d
    if-ne v3, v2, :cond_31

    goto/16 :goto_3c

    :cond_31
    invoke-static {v6, v8}, Landroid/ext/n;->b(Landroid/ext/n;I)I

    invoke-static {v10, v12, v13, v6, v3}, Landroid/ext/n;->k(Ljava/lang/String;IILandroid/ext/n;I)I

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v2

    add-int v13, v1, v0

    goto/16 :goto_1a

    :cond_32
    const/16 v0, 0x27

    if-ne v2, v0, :cond_33

    const/4 v0, 0x1

    goto :goto_1e

    :cond_33
    const/4 v0, 0x0

    :goto_1e
    add-int/lit8 v13, v1, 0x1

    invoke-static {v10, v12, v13}, Landroid/ext/n;->g(Ljava/lang/String;II)C

    move-result v1

    const/16 v2, 0x45

    if-ne v1, v2, :cond_34

    const-string v2, "EQ"

    invoke-virtual {v7, v2}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_37

    iget v0, v7, Landroid/ext/n$d;->f1090c:I

    :goto_1f
    add-int/lit8 v0, v0, -0x2

    iput v0, v7, Landroid/ext/n$d;->f1090c:I

    goto/16 :goto_15

    :cond_34
    const/16 v2, 0x4c

    if-ne v1, v2, :cond_37

    const-string v2, "LEQ"

    invoke-virtual {v7, v2}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_35

    iget v2, v7, Landroid/ext/n$d;->f1090c:I

    add-int/lit8 v2, v2, -0x3

    iput v2, v7, Landroid/ext/n$d;->f1090c:I

    goto :goto_20

    :cond_35
    const-string v2, "LS"

    invoke-virtual {v7, v2}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_36

    const-string v2, "LT"

    invoke-virtual {v7, v2}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_36

    const-string v2, "LE"

    invoke-virtual {v7, v2}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_37

    :cond_36
    iget v0, v7, Landroid/ext/n$d;->f1090c:I

    goto :goto_1f

    :cond_37
    :goto_20
    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-ne v1, v0, :cond_1c

    invoke-static/range {p0 .. p0}, Landroid/ext/n;->a(Landroid/ext/n;)I

    move-result v0

    :cond_38
    :goto_21
    move v8, v0

    goto/16 :goto_15

    :cond_39
    move-object/from16 v24, v0

    move/from16 p3, v2

    move/from16 v25, v14

    const/16 v0, 0x54

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_1c

    or-int v0, v8, v16

    goto :goto_21

    :cond_3a
    move-object/from16 v24, v0

    move/from16 p3, v2

    move/from16 v25, v14

    goto/16 :goto_24

    :cond_3b
    move-object/from16 v24, v0

    move/from16 p3, v2

    move/from16 v25, v14

    const/16 v0, 0x23

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_3c

    goto/16 :goto_3c

    :cond_3c
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    const v0, 0xf000

    and-int/2addr v0, v1

    shl-int/lit8 v0, v0, 0x4

    and-int/lit16 v2, v1, 0xfff

    or-int/2addr v0, v2

    or-int/2addr v0, v8

    const/high16 v2, -0x10000

    and-int/2addr v1, v2

    if-eqz v1, :cond_38

    :goto_22
    move v8, v0

    goto/16 :goto_10

    :cond_3d
    move-object/from16 v24, v0

    move/from16 p3, v2

    move/from16 v25, v14

    and-int/lit16 v0, v8, 0xf0

    const/16 v1, 0x60

    if-ne v0, v1, :cond_40

    const-string v0, "SY"

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3e

    or-int/lit8 v0, v8, 0x6f

    goto :goto_21

    :cond_3e
    const/16 v0, 0x23

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_9f

    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    and-int/lit8 v0, v1, 0xf

    or-int/lit8 v0, v0, 0x60

    or-int/2addr v0, v8

    and-int/lit8 v1, v1, -0x10

    if-eqz v1, :cond_3f

    :goto_23
    move v14, v13

    goto/16 :goto_e

    :cond_3f
    move/from16 v14, v25

    goto/16 :goto_e

    :cond_40
    invoke-static {v7}, Landroid/ext/n;->h(Landroid/ext/n$d;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_41

    goto/16 :goto_3c

    :cond_41
    or-int v1, v8, v0

    and-int/lit8 v2, v1, 0xf

    if-eq v2, v0, :cond_42

    move v14, v13

    goto/16 :goto_11

    :cond_42
    move/from16 v14, v25

    goto/16 :goto_11

    :goto_24
    const/16 v0, 0x5b

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_43

    goto/16 :goto_3c

    :cond_43
    sget-object v0, Landroid/ext/n;->f1076e:[Ljava/lang/String;

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v2

    const/4 v3, -0x1

    if-ne v2, v3, :cond_44

    goto/16 :goto_3c

    :cond_44
    shl-int/lit8 v3, v2, 0x10

    or-int/2addr v8, v3

    const/high16 v3, 0x4f0000

    and-int/2addr v3, v8

    const/high16 v14, 0x4f0000

    if-ne v3, v14, :cond_4b

    if-eq v2, v1, :cond_45

    goto/16 :goto_3c

    :cond_45
    const-string v0, ",#"

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0
    :try_end_6
    .catch Landroid/ext/n$f; {:try_start_6 .. :try_end_6} :catch_2

    if-eqz v0, :cond_48

    or-int v0, v8, v18

    const/16 v1, 0x2d

    :try_start_7
    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1
    :try_end_7
    .catch Landroid/ext/n$f; {:try_start_7 .. :try_end_7} :catch_5

    if-nez v1, :cond_46

    const/high16 v0, 0x1800000

    or-int/2addr v0, v8

    :cond_46
    move v8, v0

    :try_start_8
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    and-int/lit16 v0, v1, 0xf0

    shl-int/lit8 v0, v0, 0x4

    and-int/lit8 v2, v1, 0xf

    or-int/2addr v0, v2

    or-int/2addr v8, v0

    const/16 v0, 0x5d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_47

    goto/16 :goto_3c

    :cond_47
    and-int/lit16 v0, v1, -0x100

    if-eqz v0, :cond_1c

    goto/16 :goto_10

    :catch_5
    nop

    goto/16 :goto_2b

    :cond_48
    const/16 v0, 0x5d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_9f

    const-string v0, ", #"

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4a

    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_49

    or-int v0, v8, v19

    move v8, v0

    :cond_49
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    and-int/lit16 v0, v1, 0xf0

    shl-int/lit8 v0, v0, 0x4

    and-int/lit8 v2, v1, 0xf

    or-int/2addr v0, v2

    or-int/2addr v0, v8

    and-int/lit16 v1, v1, -0x100

    if-eqz v1, :cond_3f

    goto/16 :goto_23

    :cond_4a
    const/high16 v0, 0x1800000

    :goto_25
    or-int/2addr v0, v8

    goto/16 :goto_21

    :cond_4b
    const-string v1, ","

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1
    :try_end_8
    .catch Landroid/ext/n$f; {:try_start_8 .. :try_end_8} :catch_2

    if-eqz v1, :cond_54

    or-int v1, v8, v18

    const/16 v2, 0x23

    :try_start_9
    invoke-virtual {v7, v2}, Landroid/ext/n$d;->a(C)Z

    move-result v2
    :try_end_9
    .catch Landroid/ext/n$f; {:try_start_9 .. :try_end_9} :catch_6

    if-eqz v2, :cond_4f

    and-int v0, v11, v22

    if-eqz v0, :cond_4c

    and-int v0, v1, v22

    if-nez v0, :cond_4c

    :goto_26
    move v8, v1

    goto/16 :goto_3c

    :cond_4c
    const/high16 v0, 0x1400000

    or-int/2addr v0, v8

    const/16 v1, 0x2d

    :try_start_a
    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1
    :try_end_a
    .catch Landroid/ext/n$f; {:try_start_a .. :try_end_a} :catch_5

    if-nez v1, :cond_4d

    const/high16 v0, 0x1c00000

    or-int/2addr v0, v8

    :cond_4d
    move v8, v0

    :try_start_b
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0
    :try_end_b
    .catch Landroid/ext/n$f; {:try_start_b .. :try_end_b} :catch_2

    long-to-int v1, v0

    and-int/lit16 v0, v1, 0xf0

    shl-int/lit8 v0, v0, 0x4

    and-int/lit8 v2, v1, 0xf

    or-int/2addr v0, v2

    or-int/2addr v0, v8

    and-int/lit16 v1, v1, -0x100

    if-eqz v1, :cond_4e

    move v14, v13

    goto :goto_27

    :cond_4e
    move/from16 v14, v25

    :goto_27
    move v8, v0

    :goto_28
    const/16 v0, 0x5d

    goto :goto_29

    :cond_4f
    const/16 v2, 0x2d

    :try_start_c
    invoke-virtual {v7, v2}, Landroid/ext/n$d;->a(C)Z

    move-result v2
    :try_end_c
    .catch Landroid/ext/n$f; {:try_start_c .. :try_end_c} :catch_6

    if-nez v2, :cond_50

    const/high16 v1, 0x1800000

    or-int/2addr v1, v8

    :cond_50
    move v8, v1

    :try_start_d
    invoke-virtual {v7, v0}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_51

    goto/16 :goto_3c

    :cond_51
    or-int/2addr v0, v8

    and-int v1, v0, v22

    move v8, v0

    if-eqz v1, :cond_52

    move v14, v13

    goto :goto_28

    :cond_52
    move/from16 v14, v25

    goto :goto_28

    :goto_29
    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_53

    goto/16 :goto_3c

    :cond_53
    const/16 v0, 0x21

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_8

    :goto_2a
    or-int v0, v8, v16

    goto/16 :goto_e

    :catch_6
    nop

    goto :goto_26

    :cond_54
    const/16 v1, 0x5d

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-eqz v1, :cond_9f

    invoke-virtual {v7, v9}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5a

    const/16 v1, 0x23

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1
    :try_end_d
    .catch Landroid/ext/n$f; {:try_start_d .. :try_end_d} :catch_2

    if-eqz v1, :cond_57

    and-int v0, v11, v22

    if-eqz v0, :cond_55

    and-int v0, v8, v22

    if-nez v0, :cond_55

    goto/16 :goto_3c

    :cond_55
    or-int v0, v8, v22

    const/16 v1, 0x2d

    :try_start_e
    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1
    :try_end_e
    .catch Landroid/ext/n$f; {:try_start_e .. :try_end_e} :catch_5

    if-nez v1, :cond_56

    const/high16 v0, 0xc00000

    or-int/2addr v0, v8

    :cond_56
    move v8, v0

    :try_start_f
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    and-int/lit16 v0, v1, 0xf0

    shl-int/lit8 v0, v0, 0x4

    and-int/lit8 v2, v1, 0xf

    or-int/2addr v0, v2

    or-int/2addr v0, v8

    and-int/lit16 v1, v1, -0x100

    if-eqz v1, :cond_3f

    goto/16 :goto_23

    :cond_57
    const/16 v1, 0x2d

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-nez v1, :cond_58

    or-int v1, v8, v19

    move v8, v1

    :cond_58
    invoke-virtual {v7, v0}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_59

    goto/16 :goto_3c

    :cond_59
    or-int/2addr v0, v8

    and-int v1, v0, v22

    if-eqz v1, :cond_38

    goto/16 :goto_22

    :cond_5a
    or-int v0, v8, v18

    and-int v1, v11, v22

    if-eqz v1, :cond_5b

    and-int v1, v0, v22

    if-nez v1, :cond_5b

    :goto_2b
    move v8, v0

    goto/16 :goto_3c

    :cond_5b
    const/high16 v0, 0x1c00000

    goto/16 :goto_25

    :cond_5c
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    invoke-static {v7}, Landroid/ext/n;->e(Landroid/ext/n$d;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_5d

    goto/16 :goto_3c

    :cond_5d
    and-int/lit8 v1, v0, 0x30

    shl-int/lit8 v1, v1, 0x4

    and-int/lit8 v0, v0, 0x4f

    shl-int/lit8 v0, v0, 0x10

    or-int/2addr v0, v1

    goto/16 :goto_25

    :cond_5e
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    :cond_5f
    const v0, 0x2000200

    and-int/2addr v0, v8

    const/16 v1, 0x200

    if-ne v0, v1, :cond_60

    invoke-static {v7}, Landroid/ext/n;->e(Landroid/ext/n$d;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_5d

    or-int v8, v8, v20

    and-int v0, v11, v20

    if-eqz v0, :cond_5f

    goto/16 :goto_3c

    :cond_60
    const/16 v0, 0x53

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_61

    or-int v0, v8, v22

    move v8, v0

    goto :goto_2c

    :cond_61
    const/16 v0, 0x43

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_62

    goto/16 :goto_3c

    :cond_62
    :goto_2c
    const-string v0, "PSR_"

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_63

    goto/16 :goto_3c

    :cond_63
    const/16 v0, 0x46

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_64

    const/high16 v0, 0x80000

    or-int/2addr v0, v8

    move v8, v0

    :cond_64
    const/16 v0, 0x53

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_65

    const/high16 v0, 0x40000

    or-int/2addr v0, v8

    move v8, v0

    :cond_65
    const/16 v0, 0x58

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_66

    const/high16 v0, 0x20000

    or-int/2addr v0, v8

    move v8, v0

    :cond_66
    const/16 v0, 0x43

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_1c

    const/high16 v0, 0x10000

    goto/16 :goto_25

    :cond_67
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    const/16 v0, 0x2b

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_68

    const/4 v0, 0x1

    goto :goto_2d

    :cond_68
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_69

    const/4 v0, -0x1

    goto :goto_2d

    :cond_69
    const/4 v0, 0x0

    :goto_2d
    const-string v1, "0X"

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6a

    goto/16 :goto_3c

    :cond_6a
    invoke-virtual {v7}, Landroid/ext/n$d;->f()J

    move-result-wide v1

    if-eqz v0, :cond_6b

    int-to-long v14, v0

    mul-long v14, v14, v1

    add-long v1, p1, v14

    :cond_6b
    const-wide/16 v14, 0x2

    and-long/2addr v14, v1

    const-wide/16 v16, 0x0

    cmp-long v0, v14, v16

    if-eqz v0, :cond_6d

    and-int v0, v11, v18

    if-eqz v0, :cond_6c

    and-int v0, v8, v18

    if-nez v0, :cond_6c

    goto/16 :goto_3c

    :cond_6c
    or-int v8, v8, v18

    const-wide/16 v14, 0x2

    sub-long/2addr v1, v14

    :cond_6d
    sub-long v1, v1, p1

    const-wide/16 v14, 0x8

    sub-long/2addr v1, v14

    long-to-int v0, v1

    and-int/lit8 v1, v0, 0x3

    if-eqz v1, :cond_6e

    move v14, v13

    goto :goto_2e

    :cond_6e
    move/from16 v14, v25

    :goto_2e
    shr-int/lit8 v0, v0, 0x2

    const v1, 0xffffff

    and-int/2addr v1, v0

    or-int/2addr v1, v8

    const/high16 v2, -0x1000000

    and-int/2addr v0, v2

    if-eqz v0, :cond_14

    or-int v1, v1, v19

    const/high16 v2, -0x1000000

    if-eq v0, v2, :cond_14

    goto/16 :goto_f

    :cond_6f
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    const/16 v0, 0x7b

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_70

    goto/16 :goto_3c

    :cond_70
    :goto_2f
    const/4 v0, -0x1

    :goto_30
    sget-object v1, Landroid/ext/n;->f1076e:[Ljava/lang/String;

    invoke-virtual {v7, v1}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v7}, Landroid/ext/n$d;->d()C

    move-result v2

    const/4 v3, -0x1

    if-ne v1, v3, :cond_71

    goto :goto_31

    :cond_71
    if-ne v0, v3, :cond_72

    move v0, v1

    :cond_72
    sub-int v3, v1, v0

    shl-int v3, v21, v3

    const/4 v9, 0x1

    sub-int/2addr v3, v9

    shl-int v0, v3, v0

    or-int/2addr v8, v0

    const/16 v0, 0x2d

    if-ne v2, v0, :cond_73

    move v0, v1

    goto :goto_30

    :cond_73
    const/16 v0, 0x2c

    if-ne v2, v0, :cond_74

    goto :goto_2f

    :cond_74
    :goto_31
    const/16 v0, 0x7d

    if-eq v2, v0, :cond_1c

    goto/16 :goto_3c

    :cond_75
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    const v0, 0xfff0

    and-int/2addr v0, v1

    shl-int/lit8 v0, v0, 0x4

    and-int/lit8 v2, v1, 0xf

    or-int/2addr v0, v2

    or-int/2addr v0, v8

    const/high16 v2, -0x10000

    and-int/2addr v1, v2

    if-eqz v1, :cond_38

    goto/16 :goto_22

    :cond_76
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    goto/16 :goto_16

    :goto_32
    const/16 v0, 0x5b

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_77

    goto/16 :goto_3c

    :cond_77
    sget-object v0, Landroid/ext/n;->f1076e:[Ljava/lang/String;

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->j([Ljava/lang/String;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_78

    goto/16 :goto_3c

    :cond_78
    shl-int/lit8 v0, v0, 0x10

    or-int/2addr v0, v8

    move v8, v0

    :cond_79
    :goto_33
    const/high16 v0, 0xf0000

    and-int/2addr v0, v8

    const/high16 v1, 0xf0000

    if-ne v0, v1, :cond_85

    and-int v0, v8, v20

    if-nez v0, :cond_85

    const-string v0, ",#"

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7e

    const/16 v0, 0x50

    if-eq v3, v0, :cond_7a

    or-int v0, v8, v18

    move v8, v0

    :cond_7a
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_7b

    or-int v0, v8, v19

    move v8, v0

    :cond_7b
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    or-int/2addr v8, v1

    const/16 v0, 0x5d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_7c

    goto/16 :goto_3c

    :cond_7c
    const/16 v0, 0x21

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_7d

    or-int v8, v8, v16

    :cond_7d
    and-int/lit16 v0, v1, -0x1000

    if-eqz v0, :cond_1c

    goto/16 :goto_10

    :cond_7e
    const/16 v0, 0x5d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-eqz v1, :cond_84

    invoke-virtual {v7, v9}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_82

    const/16 v0, 0x23

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-nez v1, :cond_80

    or-int v8, v8, v20

    and-int v0, v11, v20

    if-eqz v0, :cond_7f

    goto/16 :goto_3c

    :cond_7f
    iget v0, v7, Landroid/ext/n$d;->f1090c:I

    add-int/lit8 v0, v0, -0x3

    iput v0, v7, Landroid/ext/n$d;->f1090c:I

    goto :goto_33

    :cond_80
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_81

    or-int v0, v8, v19

    move v8, v0

    :cond_81
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    or-int v0, v8, v1

    and-int/lit16 v1, v1, -0x1000

    if-eqz v1, :cond_3f

    goto/16 :goto_23

    :cond_82
    const/16 v0, 0x50

    if-eq v3, v0, :cond_83

    :goto_34
    or-int v8, v8, v18

    :cond_83
    or-int v0, v8, v19

    goto/16 :goto_21

    :cond_84
    or-int v8, v8, v20

    and-int v0, v11, v20

    if-eqz v0, :cond_79

    goto/16 :goto_3c

    :cond_85
    const/16 v0, 0x2c

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_8d

    const/16 v0, 0x50

    if-eq v3, v0, :cond_86

    or-int v0, v8, v18

    move v8, v0

    :cond_86
    and-int v0, v8, v20

    if-nez v0, :cond_8a

    const/16 v0, 0x23

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-nez v1, :cond_87

    or-int v8, v8, v20

    and-int v0, v11, v20

    if-eqz v0, :cond_86

    goto/16 :goto_3c

    :cond_87
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_88

    or-int v0, v8, v19

    move v8, v0

    :cond_88
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    or-int v0, v8, v1

    and-int/lit16 v1, v1, -0x1000

    if-eqz v1, :cond_89

    move v14, v13

    goto :goto_35

    :cond_89
    move/from16 v14, v25

    :goto_35
    move v8, v0

    :goto_36
    const/16 v0, 0x5d

    goto :goto_37

    :cond_8a
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_8b

    or-int v0, v8, v19

    move v8, v0

    :cond_8b
    const/4 v0, 0x1

    invoke-static {v8, v7, v0}, Landroid/ext/n;->l(ILandroid/ext/n$d;Z)I

    move-result v1

    move v8, v1

    move/from16 v14, v25

    goto :goto_36

    :goto_37
    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_8c

    goto/16 :goto_3c

    :cond_8c
    const/16 v0, 0x21

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_8

    goto/16 :goto_2a

    :cond_8d
    const/16 v0, 0x5d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-eqz v0, :cond_9f

    invoke-virtual {v7, v9}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_93

    :cond_8e
    and-int v0, v8, v20

    if-nez v0, :cond_91

    const/16 v0, 0x23

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v1

    if-nez v1, :cond_8f

    or-int v8, v8, v20

    and-int v0, v11, v20

    if-eqz v0, :cond_8e

    goto/16 :goto_3c

    :cond_8f
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_90

    or-int v0, v8, v19

    move v8, v0

    :cond_90
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    or-int v0, v8, v1

    and-int/lit16 v1, v1, -0x1000

    if-eqz v1, :cond_3f

    goto/16 :goto_23

    :cond_91
    const/16 v0, 0x2d

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_92

    or-int v0, v8, v19

    move v8, v0

    :cond_92
    const/4 v0, 0x1

    invoke-static {v8, v7, v0}, Landroid/ext/n;->l(ILandroid/ext/n$d;Z)I

    move-result v1

    goto/16 :goto_14

    :cond_93
    and-int v0, v8, v20

    if-nez v0, :cond_9f

    const/16 v0, 0x50

    if-eq v3, v0, :cond_83

    goto/16 :goto_34

    :cond_94
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    const/16 v0, 0x23

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_95

    goto/16 :goto_3c

    :cond_95
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v0

    long-to-int v1, v0

    and-int/lit8 v0, v1, -0x20

    if-eqz v0, :cond_96

    move v14, v13

    goto :goto_38

    :cond_96
    move/from16 v14, v25

    :goto_38
    shl-int/lit8 v0, v1, 0x7

    or-int/2addr v8, v0

    const-string v0, ", #"

    invoke-virtual {v7, v0}, Landroid/ext/n$d;->b(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_97

    goto/16 :goto_3c

    :cond_97
    invoke-virtual {v7}, Landroid/ext/n$d;->g()J

    move-result-wide v2

    long-to-int v0, v2

    if-gtz v0, :cond_98

    goto/16 :goto_3c

    :cond_98
    add-int/2addr v0, v1

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    shl-int/lit8 v1, v0, 0x10

    or-int/2addr v1, v8

    and-int/lit8 v0, v0, -0x20

    if-eqz v0, :cond_14

    goto/16 :goto_f

    :cond_99
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    move/from16 p3, v2

    move/from16 v25, v14

    invoke-virtual {v7, v3}, Landroid/ext/n$d;->a(C)Z

    move-result v0

    if-nez v0, :cond_1c

    goto :goto_3c

    :goto_39
    add-int/2addr v13, v0

    move/from16 v2, p3

    move-object/from16 v1, v23

    move-object/from16 v0, v24

    const/4 v9, -0x1

    goto/16 :goto_1

    :catch_7
    move-object/from16 v24, v0

    move-object/from16 v23, v1

    goto/16 :goto_12

    :goto_3a
    invoke-virtual {v7, v0}, Landroid/ext/n$d;->a(C)Z

    move/from16 v14, v25

    const/4 v1, -0x1

    if-eq v14, v1, :cond_9a

    goto :goto_3c

    :cond_9a
    invoke-virtual {v7}, Landroid/ext/n$d;->c()C

    move-result v1

    if-le v1, v0, :cond_9b

    const/16 v0, 0x3b

    if-eq v1, v0, :cond_9b

    goto :goto_3c

    :cond_9b
    and-int v0, v8, v11

    aget v1, v24, v5

    if-eq v0, v1, :cond_9c

    goto :goto_3c

    :cond_9c
    const/4 v0, 0x0

    :goto_3b
    if-ge v0, v4, :cond_9e

    mul-int/lit8 v1, v0, 0x2

    add-int/lit8 v2, v1, 0x1

    aget v2, v24, v2

    and-int v3, v8, v2

    aget v1, v24, v1
    :try_end_f
    .catch Landroid/ext/n$f; {:try_start_f .. :try_end_f} :catch_2

    if-ne v3, v1, :cond_9d

    const/high16 v1, -0x10000000

    and-int/2addr v1, v8

    const/high16 v3, -0x10000000

    if-ne v1, v3, :cond_9f

    const/high16 v1, -0x10000000

    and-int/2addr v1, v2

    const/high16 v2, -0x10000000

    if-eq v1, v2, :cond_9f

    :cond_9d
    add-int/lit8 v0, v0, 0x1

    goto :goto_3b

    :cond_9e
    return v8

    :cond_9f
    :goto_3c
    iget v0, v7, Landroid/ext/n$d;->f1090c:I

    iget v1, v7, Landroid/ext/n$d;->f1091d:I

    if-le v0, v1, :cond_a0

    iput v0, v7, Landroid/ext/n$d;->f1091d:I

    iput v8, v7, Landroid/ext/n$d;->f1092e:I

    :cond_a0
    :goto_3d
    add-int/lit8 v4, v4, 0x1

    move/from16 v2, p3

    move-object/from16 v1, v23

    move-object/from16 v0, v24

    const/4 v9, -0x1

    goto/16 :goto_0

    :cond_a1
    const/4 v0, -0x1

    return v0

    :pswitch_data_0
    .packed-switch 0x30
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_6
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x61
        :pswitch_5
        :pswitch_4
        :pswitch_3
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x6f
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
